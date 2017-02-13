/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Data.Issue_return;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinod-pt1457
 */
public class IssueReturnAccess {

    public static int add(Issue_return issue) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into issueReturn (id, isbn, issue_date, return_date, expiry_date) values(?, ?, ?, ?, ?)");
                ps.setInt(1, issue.getId());
                ps.setString(2, issue.getIsbn());
                ps.setString(3, issue.getIssueDate());
                ps.setString(4, issue.getReturnDate());
                ps.setString(5, issue.getExpiryDate());
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static int update(Issue_return issue) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update issueReturn set issue_date=?, return_date=?, expiry_date=? where id=? and isbn=?");
                ps.setString(1, issue.getIssueDate());
                ps.setString(2, issue.getReturnDate());
                ps.setString(3, issue.getExpiryDate());
                ps.setInt(4, issue.getId());
                ps.setString(5, issue.getIsbn());
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
                PreparedStatement ps = con.prepareStatement("delete from issueReturn where id=? and isbn=?");
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

    public static List<Issue_return> getAllIssues() {
        List<Issue_return> issueList = new ArrayList<>();
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from issueReturn");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Issue_return issue = new Issue_return();
                    issue.setId(rs.getInt(1));
                    issue.setIsbn(rs.getString(2));
                    issue.setIssueDate(rs.getString(3));
                    issue.setReturnDate(rs.getString(4));
                    issue.setExpiryDate(rs.getString(5));
                    issueList.add(issue);
                }
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return issueList;
    }

    public static List<Issue_return> getIssuesOfAMember(int id) {
        List<Issue_return> issueList = new ArrayList<>();
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from issueReturn where id = ?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Issue_return issue = new Issue_return();
                    issue.setId(rs.getInt(1));
                    issue.setIsbn(rs.getString(2));
                    issue.setIssueDate(rs.getString(3));
                    issue.setReturnDate(rs.getString(4));
                    issue.setExpiryDate(rs.getString(5));
                    issueList.add(issue);
                }
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return issueList;
    }

    public static List<Issue_return> getIssuesPastReturnDate() {
        List<Issue_return> issueList = new ArrayList<>();
        java.util.Date date = new java.util.Date();
        String stringDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from issueReturn where return_date < ?");
                ps.setDate(1, java.sql.Date.valueOf(stringDate));
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Issue_return issue = new Issue_return();
                    issue.setId(rs.getInt(1));
                    issue.setIsbn(rs.getString(2));
                    issue.setIssueDate(rs.getString(3));
                    issue.setReturnDate(rs.getString(4));
                    issue.setExpiryDate(rs.getString(5));
                    issueList.add(issue);
                }
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return issueList;
    }
}
