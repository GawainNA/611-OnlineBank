package model.user;

import java.util.List;

import model.Persistable;
import model.Transaction;
import util.IdCreator;

/**
 * user class of bank
 */

// TODO: all set() should update to file
public abstract class User implements Persistable{
    private int uid;
    private String username;
    private UserGender gender;
    private String passwd;
    private String address;
    private String phoneNum;

    private List<Transaction> transactionList;

    public User(String username, UserGender gender, String passwd, String address, String phoneNum) {
        this.uid = IdCreator.createRandomInt();
        this.username = username;
        this.gender = gender;
        this.passwd = passwd;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public int getUid() {
        return uid;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public UserGender getGender() {
        return gender;
    }
    public void setGender(UserGender gender) {
        this.gender = gender;
    }
    public String getPasswd() {
        return passwd;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}