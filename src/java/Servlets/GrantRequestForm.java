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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinod-pt1457
 */
public class GrantRequestForm extends HttpServlet {

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
            String isbn = request.getParameter("isbn");
            int memberId = Integer.parseInt(request.getParameter("memberId"));
//            Book book = BookAccess.getBookByIsbn(isbn);
            Date date = new Date();
            String issue_date = new SimpleDateFormat("yyyy-MM-dd").format(date);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Grant Book Form</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");

            out.println("<link rel='stylesheet' href='resources/js/jsDatePick_ltr.min.css'/>");
            out.println("<script language='JavaScript' src='resources/js/jsDatePick.min.1.3.js'></script>");
            out.println("<script src='https://code.jquery.com/jquery-1.9.1.min.js'></script>");
//            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/bootstrap.min.js'></script>");

            out.println("<script language='JavaScript' src='resources/js/grantBook.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/validation.js'></script>");

            out.println("</head>");
            out.println("<body>");
            request.getRequestDispatcher("navadmin.html").include(request, response);
            request.getRequestDispatcher("logout.html").include(request, response);

            out.println("<div class='container'>");

            out.print("<h1>Grant Book Form</h1>");
            out.print("<form name=\"addGrantForm\" onsubmit = \"return(validateGrantForm());\" action='GrantRequest' method='post'>");
            out.print("<table>");
            out.print("<tr><td><input type='hidden' name='isbn' value='" + isbn + "' /></td></tr>");
            out.print("<tr><td>MemberId:</td><td><input type='number' name='memberId' value='" + memberId + "'readonly/></td></tr>");
            out.print("<tr><td>Issue Date:</td><td><input id ='inputField1' type='text' name='issue_date' value='" + issue_date + "'/></td></tr>");
            out.print("<tr><td>Return Date:</td><td><input id ='inputField2' type='text' name='return_date'/></td></tr>");
            out.print("<tr><td>Expiry Date:</td><td><input id ='inputField3' type='text' name='expiry_date'/></td></tr>");
            out.print("<tr><td colspan='2' align='center'><input type='submit' value='Grant Book' class='btn btn-default'/></td></tr>");
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
