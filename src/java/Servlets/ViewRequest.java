/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.Book;
import Data.Member;
import Data.Request_book;
import DataAccess.MemberAccess;
import DataAccess.RequestBookAccess;
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
public class ViewRequest extends HttpServlet {

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
            out.println("<title>View Request</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            out.println("<script  language='JavaScript' src='resources/jquery.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/bootstrap.min.js'></script>");
            out.println("<script  language='JavaScript' src='resources/js/notifications.js'></script>");

            out.println("</head>");
            out.println("<body>");
//            request.getRequestDispatcher("navadmin.html").include(request, response);
            //delete dialog
            out.println("<div id='delete_message'>");
            out.println("<h2>Are You Sure You Want To Delete This ?</h2>");
            out.println("<input type='button' value='Delete' id='delete'>");
            out.println("<input type='button' value='Cancel' id='cancel'>");
            out.println("</div>");
            HttpSession session = request.getSession(false);

            if (session == null || session.getAttribute("admin") == null) {
//                out.println("<h1>Not Admin!</h1>");
                response.sendRedirect("index.html");
            } else {
                List<Request_book> list = RequestBookAccess.getAllRequests();

                if (list.size() > 0) {
                    out.println("<div class='container'>");
                    out.print("<h1>View Request</h1>");

                    out.println("<table class='table table-bordered table-striped'>");
                    out.print("<tr><th>Member ID</th><th>Book ISBN</th><th>Request Date</th><th>Grant</th><th>Delete</th>");
//                    Integer count = 0;
                    for (Iterator<Request_book> it = list.iterator(); it.hasNext();) {
//                    list.forEach((req) -> {
                        Request_book req = it.next();
//                        out.print("<tr><td>" + req.getId() + "</td><td>" + req.getIsbn() + "</td><td>" + req.getRequestDate() + "</td><td><a href='GrantRequestForm?memberId=" + req.getId() + "&isbn=" + req.getIsbn() + "'>Grant</a></td><td><a href='DeleteRequest?memberId=" + req.getId() + "&isbn=" + req.getIsbn() + "'>Delete</a></td></tr>");
                        out.print("<tr><td>" + req.getId() + "</td><td>" + req.getIsbn() + "</td><td>" + req.getRequestDate() + "</td><td><a href='GrantRequestForm?memberId=" + req.getId() + "&isbn=" + req.getIsbn() + "'>Grant</a></td><td><a href='#' onclick=\"deleteRequest(" + req.getId() + "," + req.getIsbn() + ")\" >Delete</a></td></tr>"
                        );
                    }
                    out.println("</table>");
//                    request.getRequestDispatcher("ViewPayment").include(request, response);

                    out.println("</div>");
                }
                request.getRequestDispatcher("ViewPayment").include(request, response);

            }
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
