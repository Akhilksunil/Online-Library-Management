/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.Issue_return;
import DataAccess.BookAccess;
import DataAccess.IssueReturnAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinod-pt1457
 */
public class ViewMyIssues extends HttpServlet {

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
            out.println("<title>My Books</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/bootstrap.min.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/notifications.js'></script>");

            out.println("</head>");
            out.println("<body>");
            request.getRequestDispatcher("navmember.html").include(request, response);
            request.getRequestDispatcher("logout.html").include(request, response);

//            delete dialog
            out.println("<div id='confirm_message'>");
            out.println("<h2>Are You Sure You Want To Return This ?</h2>");
            out.println("<input type='button' value='Confirm' id='confirm'>");
            out.println("<input type='button' value='Cancel' id='cancel_confirm'>");
            out.println("</div>");

            out.println("<div class='container'>");
            out.print("<h1>My Books</h1>");

            int memberId = (int) request.getSession().getAttribute("memberId");
            List<Issue_return> list = IssueReturnAccess.getIssuesOfAMember(memberId);
            out.println("<table class='table table-bordered table-striped'>");
            out.print("<tr><th>Book ISBN</th><th>Book Name</th><th>Issue Date</th><th>Return Date</th><th>Expiry Date</th><th>Return</th></tr>");
            list.forEach((issue) -> {
                out.print("<tr><td>" + issue.getIsbn() + "</td><td>" + BookAccess.getBookByIsbn(issue.getIsbn()).getName() + "</td><td>" + issue.getIssueDate() + "</td><td>" + issue.getReturnDate() + "</td><td>" + issue.getExpiryDate() + "</td><td><a href='#' onclick=\"returnBook(" + issue.getId() + "," + issue.getIsbn() + ")\">Return</a></td></tr>");
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
