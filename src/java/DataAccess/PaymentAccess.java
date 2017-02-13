/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Data.Payment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinod-pt1457
 */
public class PaymentAccess {

    public static int add(Payment payment) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into payment(id, isbn, amount, payment_date) values(?, ?, ?, ?)");
                ps.setInt(1, payment.getId());
                ps.setString(2, payment.getIsbn());
                ps.setInt(3, payment.getAmount());
                ps.setString(4, payment.getPaymentDate());
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static int update(Payment payment) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update payment set amount=? where id=? and isbn=?");
                ps.setInt(1, payment.getAmount());
                ps.setInt(2, payment.getId());
                ps.setString(3, payment.getIsbn());
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static int delete(String isbn, int id) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from payment where id=? and isbn=?");
                ps.setInt(1, id);
                ps.setString(2, isbn);
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static List<Payment> getAllPayments() {
        List<Payment> paymentList = new ArrayList<>();
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from payment");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Payment payment = new Payment();
                    payment.setId(rs.getInt(1));
                    payment.setIsbn(rs.getString(2));
                    payment.setAmount(rs.getInt(3));
                    payment.setPaymentDate(rs.getString(4));
                    paymentList.add(payment);
                }
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return paymentList;
    }
}
