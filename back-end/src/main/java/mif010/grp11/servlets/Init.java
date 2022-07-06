package mif010.grp11.servlets;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import mif010.grp11.dao.FarmDAO;
import mif010.grp11.dao.MinerDAO;
import mif010.grp11.dao.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "init", loadOnStartup = 1, value = {})
public class Init extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);

    Algorithm algorithm = Algorithm.HMAC256("secret");
    JWTVerifier verifier = JWT.require(algorithm).acceptExpiresAt(36000)
        .withIssuer("cco2").build();
    config.getServletContext().setAttribute("verifier", verifier);

    EntityManager em = Persistence.createEntityManagerFactory("pu-cco2").createEntityManager();
    config.getServletContext().setAttribute("em", em);
    config.getServletContext().setAttribute("ud", new UserDAO(em));
    config.getServletContext().setAttribute("fd", new FarmDAO(em));
    config.getServletContext().setAttribute("md", new MinerDAO(em));
    config.getServletContext().setAttribute("om", new ObjectMapper());
  }
}
