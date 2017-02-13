/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author vinod-pt1457
 */
public class Request_book {
	private int id;
    private String isbn, request_date;
    public Request_book(){
    	super();
    }
    public Request_book(int id, String isbn, String request_date){
    	this.id = id;
    	this.isbn = isbn;
    	this.request_date = request_date;
    }
    public int getId(){
    	return id;
    }
    public void setId(int id){
    	this.id = id;
    }
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }
    public String getRequestDate(){
    	return request_date;
    }
    public void setRequestDate(String request_date){
    	this.request_date = request_date;
    }
}
