/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinod-pt1457
 */
@WebFilter("*")
public class NoCacheFilter implements Filter {

    // ... (just implement init() and destroy() with empty bodies).
    @Override
    public void init(FilterConfig fc) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");

// Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Expires", "0"); // Proxies.
        chain.doFilter(req, res);
//
////
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            response.sendRedirect("index.html"); // No logged-in user found, so redirect to login page.
//            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
//            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
//            response.setDateHeader("Expires", 0);
//        } else if (session.getAttribute("admin") != null) {
//            response.sendRedirect("AdminHome"); // No logged-in user found, so redirect to login page.
//        } else if (session.getAttribute("member") != null) {
//            response.sendRedirect("MemberHome"); // No logged-in user found, so redirect to login page.
//        } else {
//            chain.doFilter(req, res);
//        }
    }

    @Override
    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
