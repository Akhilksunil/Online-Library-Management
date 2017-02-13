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
public class Member {

    private int id;
    private String name, password, gender, dob, address, contact;

    public Member() {
        super();
    }

    public Member(String name, String password, String gender, String dob, String address, String contact) {
        super();
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.contact = contact;
    }

    public Member(int id, String name, String password, String gender, String dob, String address, String contact) {
        super();
        this.id = id;
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}
