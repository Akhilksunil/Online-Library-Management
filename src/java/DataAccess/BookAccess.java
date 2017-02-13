/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Data.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinod-pt1457
 */
public class BookAccess {

    public static int add(Book book) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("insert into books(isbn, name, author_name, publisher, price, edition, subject, copies) values(?, ?, ?, ?, ?, ?, ?, ?);");
//                PreparedStatement ps = con.prepareStatement("insert into books(isbn, name, author_name, publisher, price, edition, subject, copies) values("71627", "as", "sdas", "asd", 1322, "sdad", "aeqw", 121);");
                ps.setString(1, book.getIsbn());
                ps.setString(2, book.getName());
                ps.setString(3, book.getAuthorName());
                ps.setString(4, book.getPublisher());
                ps.setInt(5, book.getPrice());
                ps.setString(6, book.getEdition());
                ps.setString(7, book.getSubject());
                ps.setInt(8, book.getCopies());
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static int update(Book book) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("update books set name=?, author_name=?, publisher=?, price=?, edition=?, subject=?, copies=? where isbn=?");
                ps.setString(1, book.getName());
                ps.setString(2, book.getAuthorName());
                ps.setString(3, book.getPublisher());
                ps.setInt(4, book.getPrice());
                ps.setString(5, book.getEdition());
                ps.setString(6, book.getSubject());
                ps.setInt(7, book.getCopies());
                ps.setString(8, book.getIsbn());
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static int delete(String isbn) {
        int status = 0;
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("delete from books where isbn=?");
                ps.setString(1, isbn);
                status = ps.executeUpdate();
                con.close();
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return status;
    }

    public static List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from books");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Book book = new Book();
                    book.setIsbn(rs.getString(1));
                    book.setName(rs.getString(2));
                    book.setAuthorName(rs.getString(3));
                    book.setPublisher(rs.getString(4));
                    book.setPrice(rs.getInt(5));
                    book.setEdition(rs.getString(6));
                    book.setSubject(rs.getString(7));
                    book.setCopies(rs.getInt(8));
                    bookList.add(book);
                }
                con.close();
            }
        }catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return bookList;
    }

    public static Book getBookByIsbn(String isbn) {
        Book book = new Book();
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from books where isbn=?");
                ps.setString(1, isbn);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    book.setIsbn(rs.getString(1));
                    book.setName(rs.getString(2));
                    book.setAuthorName(rs.getString(3));
                    book.setPublisher(rs.getString(4));
                    book.setPrice(rs.getInt(5));
                    book.setEdition(rs.getString(6));
                    book.setSubject(rs.getString(7));
                    book.setCopies(rs.getInt(8));
                }
                con.close();
            }
        }catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return book;
    }

    public static List<Book> getBookByName(String name) {
        List<Book> bookList = new ArrayList<>();
        try {
            try (Connection con = DBConnection.getConnection()) {
                PreparedStatement ps = con.prepareStatement("select * from books where name like ?");
                ps.setString(1, "%"+name+"%");
                // ps.setString(1, name);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Book book = new Book();
                    book.setIsbn(rs.getString(1));
                    book.setName(rs.getString(2));
                    book.setAuthorName(rs.getString(3));
                    book.setPublisher(rs.getString(4));
                    book.setPrice(rs.getInt(5));
                    book.setEdition(rs.getString(6));
                    book.setSubject(rs.getString(7));
                    book.setCopies(rs.getInt(8));
                    bookList.add(book);
                }
                con.close();
            }
        }catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
        return bookList;
    }
}
