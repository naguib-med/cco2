package mif010.grp11.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(value = "/auth", filterName = "authe")
public class Authentication extends HttpFilter {

    public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String)session.getAttribute("user");
        if(req.getRequestURI().endsWith("test")||req.getRequestURI().endsWith("signIn")) {
            chain.doFilter(req, resp);
        } else {
            if(req.getRequestURI().endsWith("login")) {
                req.getRequestDispatcher("login").forward(req, resp);
            } else {
                if (user != null){
                    chain.doFilter(req, resp);
                } else {
                    //renvoyer une erreur
                }
            }
        }
    }

}
