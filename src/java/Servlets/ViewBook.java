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
import java.util.Iterator;
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
public class ViewBook extends HttpServlet {

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
            out.println("<title>View Book</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");

            //wikiSearch
            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");

            out.println("<script language='JavaScript' src='resources/js/wikiSearch.js'></script>");

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
            out.print("<h1>View Book</h1>");

            List<Book> list = BookAccess.getAllBooks();
            out.println("<table class='table table-bordered table-striped'>");
            Integer count = 0;
            if (session.getAttribute("admin") != null) {
                out.print("<tr><th>ISBN</th><th>Name</th><th>Author</th><th>Publisher</th><th>Price</th><th>Edition</th><th>Subject</th><th>Copies</th><th>Edit</th><th>Delete</th>");
                for (Iterator<Book> it = list.iterator(); it.hasNext();) {
                    Book book = it.next();
                    out.print("<tr><td>" + book.getIsbn() + "</td><td><a class='not-active' id='myId" + count.toString() + "'>" + book.getName() + "</a></td><td>" + book.getAuthorName() + "</td><td>" + book.getPublisher() + "</td><td>" + book.getPrice() + "</td><td>" + book.getEdition() + "</td><td>" + book.getSubject() + "</td><td>" + book.getCopies() + "</td><td><a href='EditBookForm?isbn=" + book.getIsbn() + "'>Edit</a></td><td><a href='DeleteBook?isbn=" + book.getIsbn() + "'>Delete</a></td></tr>");
                    count++;
                }
            } else if (session.getAttribute("member") != null) {
                count = 0;
                out.print("<tr><th>ISBN</th><th>Name</th><th>Author</th><th>Publisher</th><th>Price</th><th>Edition</th><th>Subject</th><th>Copies</th><th>Request</th>");
                for (Iterator<Book> it = list.iterator(); it.hasNext();) {
                    Book book = it.next();
                    out.print("<tr><td>" + book.getIsbn() + "</td><td><a class='not-active' id='myId" + count.toString() + "'>" + book.getName() + "</td><td>" + book.getAuthorName() + "</td><td>" + book.getPublisher() + "</td><td>" + book.getPrice() + "</td><td>" + book.getEdition() + "</td><td>" + book.getSubject() + "</td><td>" + book.getCopies() + "</td><td><a href='RequestBook?isbn=" + book.getIsbn() + "&memberId=" + session.getAttribute("memberId") + "'>Request</a></td>");
                    count++;
                }
            } else {

            }
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
