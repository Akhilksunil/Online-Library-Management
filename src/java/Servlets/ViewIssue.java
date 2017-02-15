/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.Issue_return;
import Data.Request_book;
import DataAccess.IssueReturnAccess;
import DataAccess.RequestBookAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinod-pt1457
 */
public class ViewIssue extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>View Issue</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/bootstrap.min.js'></script>");

            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            if (session.getAttribute("admin") != null) {
                request.getRequestDispatcher("navadmin.html").include(request, response);
            } else if (session.getAttribute("member") != null) {
                request.getRequestDispatcher("navmember.html").include(request, response);
            } else {
                response.sendRedirect("index.html");
            }
            request.getRequestDispatcher("logout.html").include(request, response);

            out.println("<div class='container'>");
            out.print("<h1>View Issue</h1>");

            List<Issue_return> list = IssueReturnAccess.getAllIssues();
            out.println("<table class='table table-bordered table-striped'>");
            out.print("<tr><th>Member ID</th><th>Book ISBN</th><th>Issue Date</th><th>Return Date</th><th>Expiry Date</th>");
            list.forEach((issue) -> {
                out.print("<tr><td>" + issue.getId() + "</td><td>" + issue.getIsbn() + "</td><td>" + issue.getIssueDate() + "</td><td>" + issue.getReturnDate() + "</td><td>" + issue.getExpiryDate() + "</td></tr>");
            });
            out.println("</table>");

            out.println("</div>");
            request.getRequestDispatcher("footer.html").include(request, response);
            out.println("</body>");
            out.println("</html>");

            out.close();
        }
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
