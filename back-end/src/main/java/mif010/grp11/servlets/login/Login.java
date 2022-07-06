package mif010.grp11.servlets.login;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mif010.grp11.dao.UserDAO;
import mif010.grp11.filters.AuthFilter;
import mif010.grp11.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login", urlPatterns = "/login")
public class Login extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    UserDAO ud = (UserDAO) getServletContext().getAttribute("ud");
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    resp.setContentType("text/plain");
    if (!ud.userExists(username)) {
      resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"User does not exist");
    } else if (!ud.passwordCorrect(username,password)) {
      resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Password incorrect");
    } else {
      PrintWriter out = resp.getWriter();

      String token = null;
      try {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        token = JWT.create().withIssuer("cco2")
            .withClaim("user",ud.authUser(username,password))
            .sign(algorithm);
      } catch (JWTCreationException e) {
        e.printStackTrace();
      }
      out.write(token);
    }
  }
}
