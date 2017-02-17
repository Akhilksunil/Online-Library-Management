/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.Member;
import DataAccess.MemberAccess;
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
public class ViewMember extends HttpServlet {

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
            out.println("<title>View Member</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            out.println("<link rel='stylesheet' href='resources/js/notyf.min.css' />");
            out.println("<link rel='stylesheet' href='resources/js/jsDatePick_ltr.min.css'/>");
            out.println("<link rel='stylesheet' href='resources/js/simpleFlexible.css'/>");

            out.println("<script src='https://code.jquery.com/jquery-1.9.1.min.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/notyf.min.js'></script>");
            out.println("<script language='JavaScript' src='resources/bootstrap.min.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/jsDatePick.min.1.3.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/simpleFlexible.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/editMemberModal.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/notifications.js'></script>");
            out.println("<script language='JavaScript' src='resources/js/validation.js'></script>");

            out.println("</head>");
            out.println("<body>");
            request.getRequestDispatcher("navadmin.html").include(request, response);
            request.getRequestDispatcher("logout.html").include(request, response);
//            delete dialog
            out.println("<div id='delete_message'>");
            out.println("<h2>Are You Sure You Want To Delete This ?</h2>");
            out.println("<input type='button' value='Delete' id='delete'>");
            out.println("<input type='button' value='Cancel' id='cancel'>");
            out.println("</div>");

//            edit member dialog
            out.println("<div id=\"dialog\"></div>");

            out.println("<div class='container'>");
            out.print("<h1>View Member</h1>");

            List<Member> list = MemberAccess.getAllMembers();
            out.println("<table class='table table-bordered table-striped'>");
            HttpSession session = request.getSession();
            out.print("<tr><th>ID</th><th>Name</th><th>Password</th><th>Gender</th><th>DOB</th><th>Address</th><th>Contact</th><th>Edit</th><th>Delete</th>");
            list.forEach((member) -> {
//                out.print("<tr><td>" + member.getId() + "</td><td>" + member.getName() + "</td><td>" + member.getGender() + "</td><td>" + member.getDob() + "</td><td>" + member.getAddress() + "</td><td>" + member.getContact() + "</td></td><td><a href='EditMemberForm?id=" + member.getId() + "'>Edit</a></td><td><a href='#' onclick=\"deleteMember(" + member.getId() + ")\">Delete</a></td></tr>");
                out.print("<tr><td>" + member.getId() + "</td><td>" + member.getName() + "</td><td>" + member.getPassword() + "</td><td>" + member.getGender() + "</td><td>" + member.getDob() + "</td><td>" + member.getAddress() + "</td><td>" + member.getContact() + "</td></td><td><a href='#' id='" + member.getId() + "' class='memberEditTags' >Edit</a></td><td><a href='#' onclick=\"deleteMember(" + member.getId() + ")\">Delete</a></td></tr>");

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
