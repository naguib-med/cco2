package mif010.grp11.filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

@WebFilter(filterName = "registerCheck")
public class RegisterFilter extends HttpFilter {

  @Override
  public void init(FilterConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    //res.setHeader("Access-Control-Allow-Credentials", "true");
    //res.setHeader("Access-Control-Allow-Origin", "*");
    if (
        !req.getMethod().toLowerCase(Locale.ROOT).equals("post")
        || req.getParameter("username") == null
        || req.getParameter("password") == null
        || req.getParameter("username").equals("")
        || req.getParameter("password").equals("")
    ) {
      res.sendError(HttpServletResponse.SC_BAD_REQUEST);
    } else {
      chain.doFilter(req, res);
    }
  }
}
