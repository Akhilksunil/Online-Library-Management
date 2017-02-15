/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.Book;
import DataAccess.BookAccess;
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
public class EditBookForm extends HttpServlet {

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

            String isbn = request.getParameter("isbn");
            Book book = BookAccess.getBookByIsbn(isbn);

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Edit Book</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            out.println("<link rel='stylesheet' href='resources/js/notyf.min.css' />");

            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/bootstrap.min.js'></script>");

            out.println("<script language='JavaScript' src='resources/js/notyf.min.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/notifications.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/validation.js'></script>");

            out.println("</head>");
            out.println("<body>");
            request.getRequestDispatcher("navadmin.html").include(request, response);
            request.getRequestDispatcher("logout.html").include(request, response);

            out.println("<div class='container'>");

            out.print("<h1>Edit Book Form</h1>");
            out.print("<form name=\"addBookForm\" onsubmit = \"return(validateBookForm());\" action='EditBook' method='post'>");
            out.print("<table>");
            out.print("<tr><td><input type='hidden' name='isbn' value='" + book.getIsbn() + "' /></td></tr>");
            out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + book.getName() + "'/></td></tr>");
            out.print("<tr><td>Author:</td><td><input type='text' name='author' value='" + book.getAuthorName() + "'/></td></tr>");
            out.print("<tr><td>Publisher:</td><td><input type='text' name='publisher' value='" + book.getPublisher() + "'/></td></tr>");
            out.print("<tr><td>Price:</td><td><input type='number' name='price' value='" + book.getPrice() + "'/></td></tr>");
            out.print("<tr><td>Edition:</td><td><input type='text' name='edition' value='" + book.getEdition() + "'/></td></tr>");
            out.print("<tr><td>Subject:</td><td><input type='text' name='subject' value='" + book.getSubject() + "'/></td></tr>");
            out.print("<tr><td>Copies:</td><td><input type='number' name='copies' value='" + book.getCopies() + "'/></td></tr>");
            out.print("<tr><td colspan='2' align='center'><input type='submit' value='Update Book' class='btn btn-default'/></td></tr>");
            out.print("</table>");
            out.print("</form>");
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
