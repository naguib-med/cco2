package mif010.grp11.servlets;

import mif010.grp11.jwt.PemTest;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.PrivateKey;

@WebServlet(name = "pathTest", urlPatterns = "/pathTest")
public class PathTest extends HttpServlet {
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter out = resp.getWriter();
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    try {
      PemTest.getPrivateKey();
      out.write("ok");
    } catch (IOException e) {
      e.printStackTrace(pw);
      out.write("ex");
    }
  }
}
