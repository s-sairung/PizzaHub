package chula.project.pizzahub.classes;

import java.util.Random;

public class Profile {

    private String userID;
    private String password;
    private String cardNumber;
    private int randnum;

    public Profile() {
        this("", "", "");
    }

    public Profile(String userID, String password) {
        this(userID, password, "");
    }

    public Profile(String userID, String password, String cardNumber) {
        this.userID = userID;
        this.password = password;
        this.cardNumber = cardNumber;
    }

    public String getUserID() {
        return this.userID;
    }

    public String getPassword() {
        return this.password;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

}
