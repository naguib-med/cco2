package mif010.grp11.servlets.login;

import mif010.grp11.dao.UserDAO;
import mif010.grp11.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 */

@WebServlet(name = "register", urlPatterns = "/register")
public class Register extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  /**
   *
   * @param req Requete, doit contenir les champs username et password (garanti par RegisterFilter)
   * @param resp Réponse, code 200 si la création de l'utilisateur marche, 409 si l'utilisateur existe
   *             déja dans la base de données
   * @throws ServletException
   * @throws IOException
   */

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    UserDAO ud = (UserDAO) getServletContext().getAttribute("ud");
    String username = req.getParameter("username");
    String password = req.getParameter("password");
    resp.setContentType("application/json");
    //resp.setHeader("Access-Control-Allow-Credentials", "true");
    //resp.setHeader("Access-Control-Allow-Origin", "https://192.168.74.198/");
    if (ud.userExists(username)) {
      resp.sendError(HttpServletResponse.SC_CONFLICT,"User exists");
    } else {
      ud.createOrUpdate(username, password);
      resp.sendError(HttpServletResponse.SC_OK,"Registration complete!");
    }
  }
}
