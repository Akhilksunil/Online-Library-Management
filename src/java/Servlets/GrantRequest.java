/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.Book;
import Data.Issue_return;
import DataAccess.BookAccess;
import DataAccess.IssueReturnAccess;
import DataAccess.RequestBookAccess;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinod-pt1457
 */
public class GrantRequest extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link rel='stylesheet' href='resources/js/notyf.min.css' />");
            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/bootstrap.min.js'></script>");

            out.println("<script  language='JavaScript' src='resources/js/notyf.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/js/notifications.js'></script>");

            out.println("</head>");
            out.println("<body>");
            /* TODO output your page here. You may use following sample code. */

            String isbn = request.getParameter("isbn");
            int memberId = Integer.parseInt(request.getParameter("memberId"));
            String issue_date = request.getParameter("issue_date");
            String return_date = request.getParameter("return_date");
            String expiry_date = request.getParameter("expiry_date");

            Book book = BookAccess.getBookByIsbn(isbn);
            int copies = book.getCopies();
            if (copies > 0) {
                out.println("<script language='JavaScript'>");
                out.println("success('Book Granted Successfully')");
                out.println("</script>");
                book.setCopies(copies - 1);
                BookAccess.update(book);
                Issue_return issue = new Issue_return(memberId, isbn, issue_date, return_date, expiry_date);
                int status = IssueReturnAccess.add(issue);
                RequestBookAccess.delete(isbn, memberId);
            } else {
                //notification
                out.println("<script language='JavaScript'>");
                out.println("error('Book grant not possible, Insufficient copies !')");
                out.println("</script>");

            }
            request.getRequestDispatcher("ViewIssue").include(request, response);

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
