package mif010.grp11.filters;


import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "authFilter")
public class AuthFilter extends HttpFilter {
  @Override
  public void init(FilterConfig config) throws ServletException {
    super.init(config);
  }

  @Override
  protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
    //res.setHeader("Access-Control-Allow-Credentials", "true");
    //res.setHeader("Access-Control-Allow-Origin", "*");
    String token = req.getParameter("x-access-token");
    if (token != null) {
      JWTVerifier verfifier = (JWTVerifier) getServletContext().getAttribute("verifier");
      try {
        DecodedJWT jwt = verfifier.verify(token);
        req.setAttribute("user",jwt.getClaim("user").asString());
        chain.doFilter(req, res);
      } catch (JWTVerificationException e) {
        res.sendError(HttpServletResponse.SC_FORBIDDEN);
      }
    } else {
      res.sendError(HttpServletResponse.SC_UNAUTHORIZED,"auth");
    }
  }
}