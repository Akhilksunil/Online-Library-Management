/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Data.Member;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinod-pt1457
 */
public class MemberAccess {

    public static int add(Member member) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into members(name, password, gender, dob, address, contact) values(?, ?, ?, ?, ?, ?)");
                ps.setString(1, member.getName());
                ps.setString(2, member.getPassword());
                ps.setString(3, member.getGender());
                ps.setString(4, member.getDob());
                ps.setString(5, member.getAddress());
                ps.setString(6, member.getContact());
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException ex) {
            status = -1;
            System.out.println(ex);
        } catch (SQLException ex) {
            status = -2;
        }
        return status;
    }

    public static boolean validate(int id, String password) {
        boolean status = false;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from members where id=? and password=?");
                ps.setInt(1, id);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                status = rs.next();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static int update(Member member) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update members set name=?, password=?, gender=?, dob=?, address=?, contact=? where id=?");
                ps.setString(1, member.getName());
                ps.setString(2, member.getPassword());
                ps.setString(3, member.getGender());
                ps.setString(4, member.getDob());
                ps.setString(5, member.getAddress());
                ps.setString(6, member.getContact());
                ps.setInt(7, member.getId());
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static int delete(int id) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from members where id=?");
                ps.setInt(1, id);
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static List<Member> getAllMembers() {
        List<Member> memberList = new ArrayList<>();
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from members");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Member member = new Member();
                    member.setId(rs.getInt(1));
                    member.setName(rs.getString(2));
                    member.setPassword(rs.getString(3));
                    member.setGender(rs.getString(4));
                    member.setDob(rs.getString(5));
                    member.setAddress(rs.getString(6));
                    member.setContact(rs.getString(7));
                    memberList.add(member);
                }
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return memberList;
    }

    public static Member getMemberById(int id) {
        Member member = new Member();
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from members where id=?");
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    member.setId(rs.getInt(1));
                    member.setName(rs.getString(2));
                    member.setPassword(rs.getString(3));
                    member.setGender(rs.getString(4));
                    member.setDob(rs.getString(5));
                    member.setAddress(rs.getString(6));
                    member.setContact(rs.getString(7));
                }
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return member;
    }
}
