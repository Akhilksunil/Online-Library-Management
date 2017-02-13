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
public class Issue_return {
	private int id;
    private String isbn, issue_date, return_date, expiry_date;
    public Issue_return(){
    	super();
    }
    public Issue_return(int id, String isbn, String issue_date, String return_date, String expiry_date){
    	this.id = id;
    	this.isbn = isbn;
    	this.issue_date = issue_date;
    	this.return_date = return_date;
    	this.expiry_date = expiry_date;
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
    public String getIssueDate(){
    	return issue_date;
    }
    public void setIssueDate(String issue_date){
    	this.issue_date = issue_date;
    }
    public String getReturnDate(){
    	return return_date;
    }
    public void setReturnDate(String return_date){
    	this.return_date = return_date;
    }
    public String getExpiryDate(){
    	return expiry_date;
    }
    public void setExpiryDate(String expiry_date){
    	this.expiry_date = expiry_date;
    }
}
