/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Data.Issue_return;
import Data.Payment;
import DataAccess.IssueReturnAccess;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinod-pt1457
 */
public class ViewPayment extends HttpServlet {

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
            out.println("<title>View Dues</title>");
            out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
            out.println("<link rel='stylesheet' href='style.css'/>");
            out.println("</head>");
            out.println("<body>");
            HttpSession session = request.getSession();
            if (session.getAttribute("admin") != null) {
//                request.getRequestDispatcher("navadmin.html").include(request, response);
            } else {
//                request.getRequestDispatcher("navmember.html").include(request, response);
            }

            Date d2 = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String today = new SimpleDateFormat("yyyy-MM-dd").format(d2);
            int fine = 1;

            List<Issue_return> list = IssueReturnAccess.getIssuesPastReturnDate();
            List<Payment> payList = new ArrayList<>();
            list.forEach((issue) -> {
                String return_date = issue.getReturnDate();
                Date d1;
                try {
                    d1 = format.parse(return_date);
                    long diff = d2.getTime() - d1.getTime();
                    long diffDays = diff / (24 * 60 * 60 * 1000);
                    int amt = (int) (fine * diffDays);
                    Payment payment = new Payment(issue.getId(), issue.getIsbn(), amt, issue.getReturnDate());
                    payList.add(payment);
                } catch (ParseException ex) {
                    Logger.getLogger(ViewPayment.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            //for Member
            if (session.getAttribute("member") != null) {
                List<Payment> payListMember = new ArrayList<>();
                int memberId = (int) session.getAttribute("memberId");
                payList.forEach((payment) -> {
                    if (memberId == payment.getId()) {
                        payListMember.add(payment);
                    }
                });
                if (payListMember.size() > 0) {
                    out.println("<div class='container'>");
                    out.print("<h1>View Dues</h1>");
                    out.println("<table class='table table-bordered table-striped'>");
                    out.print("<tr><th>ID</th><th>ISBN</th><th>Amount</th><th>Return Date</th></tr>");
                    payListMember.forEach((payment) -> {
                        out.print("<tr><td>" + payment.getId() + "</td><td>" + payment.getIsbn() + "</td><td>" + payment.getAmount() + "</td><td>" + payment.getPaymentDate() + "</td></tr>");
                    });
                    out.println("</table>");
                    out.println("</div>");
                }
            }
//            out.println(payList.size());
//            for Admin
            if (session.getAttribute("admin") != null && payList.size() > 0) {
                out.println("<div class='container'>");
                out.print("<h1>View Dues</h1>");
                out.println("<table class='table table-bordered table-striped'>");

                out.print("<tr><th>ID</th><th>ISBN</th><th>Amount</th><th>Return Date</th></tr>");
                payList.forEach((payment) -> {
                    out.print("<tr><td>" + payment.getId() + "</td><td>" + payment.getIsbn() + "</td><td>" + payment.getAmount() + "</td><td>" + payment.getPaymentDate() + "</td></tr>");
                });

                out.println("</table>");
                out.println("</div>");
            }
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
