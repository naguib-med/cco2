package mif010.grp11.servlets;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import mif010.grp11.dao.FarmDAO;
import mif010.grp11.dao.UserDAO;
import mif010.grp11.model.User;
import org.hibernate.JDBCException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "home", urlPatterns = "/home")
public class Home extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  /**
   * @param req
   * @param resp
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String token = req.getParameter("x-access-token");

    String username = null;
    try {
      DecodedJWT jwt = JWT.decode(token);
      username = jwt.getClaim("user").asString();
    } catch (JWTDecodeException ignored) { }

    PrintWriter out = resp.getWriter();
    resp.setContentType("application/json");
    FarmDAO fd = (FarmDAO) getServletContext().getAttribute("fd");
    UserDAO ud = (UserDAO) getServletContext().getAttribute("ud");
    ObjectMapper om = (ObjectMapper) getServletContext().getAttribute("om");
    //String username = (String) req.getSession().getAttribute("user");
    out.write(om.writeValueAsString(fd.getFarms(ud.getUserByUsername(username))));
  }
}
