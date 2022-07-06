package mif010.grp11.servlets.search;

import com.fasterxml.jackson.databind.ObjectMapper;
import mif010.grp11.dao.MinerDAO;
import mif010.grp11.model.Miner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet(name = "minerSearch", value = "/miner/search")
public class MinerSearch extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String searchTerm = req.getParameter("search");
    ObjectMapper om = (ObjectMapper) getServletContext().getAttribute("om");
    resp.setContentType("application/json");
    if (Objects.equals(searchTerm, "")) {
      resp.getWriter().write(om.writeValueAsString(new ArrayList<Miner>()));
    } else {
      MinerDAO md = (MinerDAO) getServletContext().getAttribute("md");
      resp.getWriter().write(om.writeValueAsString(md.getByNameFuzzy(searchTerm)));
    }
  }
}
