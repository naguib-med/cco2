package mif010.grp11.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import mif010.grp11.dao.FarmDAO;
import mif010.grp11.dao.MinerDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpSession;

@WebServlet(name = "test", value = "/test")
public class TestServlet extends HttpServlet {

  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    resp.setContentType("application/json");
    MinerDAO md = (MinerDAO) getServletContext().getAttribute("md");
    ObjectMapper om = (ObjectMapper) getServletContext().getAttribute("om");
    out.write(om.writeValueAsString(md.getMiners()));
  }
}
