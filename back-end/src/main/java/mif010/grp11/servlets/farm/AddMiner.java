package mif010.grp11.servlets.farm;

import mif010.grp11.dao.FarmDAO;
import mif010.grp11.dao.MinerDAO;
import mif010.grp11.model.Farm;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addMiner", urlPatterns = "/miner/add")
public class AddMiner extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String mid_s= req.getParameter("miner");
    Farm farm = (Farm) req.getAttribute("farm");

    Long mid = null;
    try {
      mid = Long.parseLong(mid_s);
    } catch (NumberFormatException e) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
    }
    if (mid == null) {
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
    } else {
      FarmDAO fd = (FarmDAO) getServletContext().getAttribute("fd");
      MinerDAO md = (MinerDAO) getServletContext().getAttribute("md");
      fd.addMiner(farm,md.getById(mid));
    }
  }
}
