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
public class Payment {

    private int id, amt;
    private String payment_date, isbn;

    public Payment() {
        super();
    }

    public Payment(int id, String isbn, int amt, String payment_date) {
        this.id = id;
        this.isbn = isbn;
        this.amt = amt;
        this.payment_date = payment_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amt;
    }

    public void setAmount(int amt) {
        this.amt = amt;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getPaymentDate() {
        return payment_date;
    }

    public void setPaymentDate(String payment_date) {
        this.payment_date = payment_date;
    }
}
