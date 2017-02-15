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
import java.util.ArrayList;
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
            out.println("<link rel='stylesheet' href='resources/js/jquery.tooltip.css'/>");
            out.println("<link rel='stylesheet' href='modal.css'/>");

            out.println("<link rel='stylesheet' href='style.css'/>");
            out.println("<link rel='stylesheet' href='resources/js/notyf.min.css' />");

            //wikiSearch
            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/bootstrap.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/js/jquery.tooltip.js'></script>");

            out.println("<script language='JavaScript' src='resources/js/wikiSearch.js'></script>");
            out.println("<script  language='JavaScript' src='resources/js/notyf.min.js'></script>");

            out.println("<script language='JavaScript' src='resources/js/notifications.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/validation.js'></script>");

            out.println("<script language='JavaScript' src='resources/js/editBookModal.js'></script>");

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
            //delete dialog
            out.println("<div id='delete_message'>");
            out.println("<h2>Are You Sure You Want To Delete This ?</h2>");
            out.println("<input type='button' value='Delete' id='delete'>");
            out.println("<input type='button' value='Cancel' id='cancel'>");
            out.println("</div>");
            //delete dialog
//            id to save the isbn of the book
            out.println("<input hidden name='editIsbn'  id ='editIsbn' type='text'/>");

//            <!-- Trigger / Open The Modal -->
//            out.println("<button id ='myBtn'> Open Modal</button>");
            //            <!-- The Modal -->
            String isbn = request.getParameter("editIsbn");
            out.println("<script language='JavaScript'>");
            out.println("console.log(" + isbn + ")");
            out.println("</script>");
//            Book book = BookAccess.getBookByIsbn(isbn);
            out.println("<div  id='myModal' class='modal'>");
//  <!-- Modal content -->

            out.println("<div class='modal-content'>");
            out.println("<div class='modal-header'>");
            out.println("<span class='close'>&times;</span>");
            out.println("<h2>Edit Book</h2>");
            out.println("</div>");
            out.println("<div class='modal-body'>");
            out.println("<br><br><br>");

            out.println("<div class='container'>");
            out.print("<form name=\"addBookForm\" onsubmit = \"return(validateBookForm());\" action='EditBook' method='post'>");
            out.print("<table>");
            out.print("<tr><td><input type='hidden' id='isbn' name='isbn'  /></td></tr>");
            out.print("<tr><td>Name:</td><td><input type='text' id='name' name='name' /></td></tr>");
            out.print("<tr><td>Author:</td><td><input type='text' id='author' name='author'/></td></tr>");
            out.print("<tr><td>Publisher:</td><td><input type='text' id='publisher' name='publisher'/></td></tr>");
            out.print("<tr><td>Price:</td><td><input type='number' id='price' name='price' /></td></tr>");
            out.print("<tr><td>Edition:</td><td><input type='text' id='edition' name='edition' /></td></tr>");
            out.print("<tr><td>Subject:</td><td><input type='text' id='subject' name='subject'/></td></tr>");
            out.print("<tr><td>Copies:</td><td><input type='number' id='copies' name='copies' /></td></tr>");
            out.print("<tr><td hidden>copies<td><td><input type='submit' value='Update Book' class='btn btn-default'/></td></tr>");
            out.print("</table>");
            out.print("</form>");
            out.println("</div>");
            out.println("<br><br><br><br><br><br>");
            out.println("</div>");
            out.println("</div>");
            out.println("</div>");

            out.println("<div class='container'>");
            List<Book> list = BookAccess.getAllBooks();

            List<String> bookNameList = new ArrayList<>();
            list.forEach((book) -> {
                bookNameList.add(book.getName());
            });
            out.println("<div hidden id='bookNames'>" + bookNameList + "</div>");

            out.print("<h1>View Book</h1>");

            out.println("<table class='table table-bordered table-striped'>");
            Integer count = 0;
            if (session.getAttribute("admin") != null) {
                out.print("<tr><th>ISBN</th><th>Name</th><th>Author</th><th>Publisher</th><th>Price</th><th>Edition</th><th>Subject</th><th>Copies</th><th>Edit</th><th>Delete</th>");
                for (Iterator<Book> it = list.iterator(); it.hasNext();) {
                    Book book = it.next();
//                    out.print("<tr><td>" + book.getIsbn() + "</td><td><a class='not-active' id='myId" + count.toString() + "'>" + book.getName() + "</a></td><td>" + book.getAuthorName() + "</td><td>" + book.getPublisher() + "</td><td>" + book.getPrice() + "</td><td>" + book.getEdition() + "</td><td>" + book.getSubject() + "</td><td>" + book.getCopies() + "</td><td><a href='EditBookForm?isbn=" + book.getIsbn() + "'>Edit</a></td><td><a href='#' onclick=\"deleteBook(" + book.getIsbn() + ")\">Delete</a></td></tr>");
                    out.print("<tr><td>" + book.getIsbn() + "</td><td><a class='not-active' id='myId" + count.toString() + "'>" + book.getName() + "</a></td><td>" + book.getAuthorName() + "</td><td>" + book.getPublisher() + "</td><td>" + book.getPrice() + "</td><td>" + book.getEdition() + "</td><td>" + book.getSubject() + "</td><td>" + book.getCopies() + "</td><td><a href='#' id='" + book.getIsbn() + "' class='editTags' >Edit</a></td><td><a href='#' onclick=\"deleteBook(" + book.getIsbn() + ")\">Delete</a></td></tr>");
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
//
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
