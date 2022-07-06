package mif010.grp11.servlets.farm;

import mif010.grp11.dao.FarmDAO;
import mif010.grp11.dao.UserDAO;
import mif010.grp11.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addFarm", urlPatterns = "/farm/add")
public class AddFarm extends HttpServlet {
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String farmName = req.getParameter("name");
    if (farmName != null) {
      FarmDAO fd = (FarmDAO) getServletContext().getAttribute("fd");
      UserDAO ud = (UserDAO) getServletContext().getAttribute("ud");
      String username = (String) req.getAttribute("user");
      User user = ud.getUserByUsername(username);
      fd.create(farmName,user);
    } else {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }
}
