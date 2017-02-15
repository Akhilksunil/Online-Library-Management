/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import DataAccess.MemberAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinod-pt1457
 */
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.addHeader("Cache-Control", "no-cache,no-store,private,must-revalidate,max-stale=0,post-check=0,pre-check=0");
        response.addHeader("Pragma", "no-cache");
        response.addDateHeader("Expires", 0);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Login</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='resources/js/notyf.min.css' />");
            out.println("<link rel='stylesheet' href='style.css'/>");

            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/bootstrap.min.js'></script>");

            out.println("<script  language='JavaScript' src='resources/js/notyf.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/js/notifications.js'></script>");
            out.println("</head>");

            out.println("<body>");
            //admin
            String email = request.getParameter("id");
            String password = request.getParameter("password");
            if (email == "" || password == "") {
                email = "e";
                password = "e";
            }
            //member
//            int id = 3;
            if (email.equals("admin") && password.equals("admin123")) {
                HttpSession session = request.getSession();
                session.setAttribute("admin", "true");
                request.getRequestDispatcher("AdminHome").include(request, response);
            } else {
                boolean status = isParsable(request.getParameter("id"));
                int id = status ? Integer.parseInt(request.getParameter("id")) : -1;
                status = MemberAccess.validate(id, password);
                if (status) {
                    HttpSession session = request.getSession();
                    session.setAttribute("member", "true");
                    session.setAttribute("memberId", id);
                    request.getRequestDispatcher("MemberHome").include(request, response);
                } else {
//                //notification
                    out.println("<script language='JavaScript'>");
                    out.println("error('Check Username or Password!!')");
                    out.println("</script>");
                    request.getRequestDispatcher("index.html").include(request, response);
                }
            }
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }

    public static boolean isParsable(String input) {
        boolean parsable = true;
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            parsable = false;
        }
        return parsable;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
