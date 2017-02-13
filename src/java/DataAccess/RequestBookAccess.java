/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Data.Issue_return;
import Data.Request_book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinod-pt1457
 */
public class RequestBookAccess {

    public static int add(Request_book request) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into requestBook(id, isbn, request_date) values(?, ?, ?)");
                ps.setInt(1, request.getId());
                ps.setString(2, request.getIsbn());
                ps.setString(3, request.getRequestDate());
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    // public static int update(Request_book request) {
    //     int status = 0;
    //     try {
    //         try (Connection con = DBConnection.getConnection()) {
    //             PreparedStatement ps = con.prepareStatement("update requestReturn set request_date=?, return_date=?, expiry_date=? where id=? and isbn=?");
    //             ps.setString(1, request.getIssueDate());
    //             ps.setString(2, request.getReturnDate());
    //             ps.setString(3, request.getExpiryDate());
    //             ps.setInt(4, request.getId());
    //             ps.setString(5, request.getIsbn());
    //             status = ps.executeUpdate();
    //             con.close();
    //         }
    //     } catch (ClassNotFoundException | SQLException ex) {
    //         System.out.println(ex);
    //     }
    //     return status;
    // }
    public static int delete(String isbn, int id) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from requestBook where id=? and isbn=?");
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

    public static List<Request_book> getAllRequests() {
        List<Request_book> requestList = new ArrayList<>();
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from requestBook");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Request_book request = new Request_book();
                    request.setId(rs.getInt(1));
                    request.setIsbn(rs.getString(2));
                    request.setRequestDate(rs.getString(3));
                    requestList.add(request);
                }
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return requestList;
    }

    public static int add(Issue_return sue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
