package mif010.grp11.filters;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "unauthFilter")
public class UnauthFilter extends HttpFilter {
  @Override
  public void init(FilterConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    //res.setHeader("Access-Control-Allow-Credentials", "true");
    //res.setHeader("Access-Control-Allow-Origin", "*");
    String token = req.getParameter("x-access-token");
    if (token == null) {
      chain.doFilter(req,res);
    } else {
      res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
  }
}
