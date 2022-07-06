package mif010.grp11.servlets.farm;

import com.fasterxml.jackson.databind.ObjectMapper;
import mif010.grp11.dao.FarmDAO;
import mif010.grp11.dao.MinerDAO;
import mif010.grp11.dao.UserDAO;
import mif010.grp11.model.Miner;
import mif010.grp11.model.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "farm", value = "/farm/*")
public class Farm extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getRequestURI().endsWith("/add")) {
      UserDAO ud = (UserDAO) getServletContext().getAttribute("ud");
      FarmDAO fd = (FarmDAO) getServletContext().getAttribute("fd");

      String username = (String) req.getAttribute("user");
      User sessionUser = ud.getUserByUsername(username);

      String[] uriSp = req.getRequestURI().split("/");
      String farmId = uriSp[uriSp.length - 2];
      Long fid = null;
      mif010.grp11.model.Farm farm = null;
      try {
        fid = Long.parseLong(farmId);
        farm = fd.getById(fid);
      } catch (NumberFormatException e) {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
      }

      if (farm != null && farm.getUid_FK() == sessionUser) {
        req.setAttribute("farm", farm);
        req.getRequestDispatcher("/miner/add").forward(req, resp);
      } else {
        resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
      }
    } else {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    if (req.getRequestURI().endsWith("/add")) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
    } else {
      UserDAO ud = (UserDAO) getServletContext().getAttribute("ud");
      String username = (String) req.getAttribute("user");
      User sessionUser = ud.getUserByUsername(username);
      String[] uriSp = req.getRequestURI().split("/");
      String farmId = uriSp[uriSp.length - 1];
      FarmDAO fd = (FarmDAO) getServletContext().getAttribute("fd");
      Long fid = null;
      try {
        fid = Long.parseLong(farmId);
      } catch (NumberFormatException e) {
        resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
      }
      mif010.grp11.model.Farm farm = fd.getById(fid);
      if (fid != null && farm.getUid_FK() == sessionUser) {
        ObjectMapper om = (ObjectMapper) getServletContext().getAttribute("om");
        MinerDAO md = (MinerDAO) getServletContext().getAttribute("md");
        List<Miner> minerList = md.getByFarm(farm);
        resp.setContentType("application/json");
        resp.getWriter().write(om.writeValueAsString(minerList));
      } else {
        resp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
      }
    }
  }

}
