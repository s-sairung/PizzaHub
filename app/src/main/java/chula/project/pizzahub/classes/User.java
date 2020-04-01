package chula.project.pizzahub.classes;

public class User {

    private String userID;
    private String password;
    private int cardNumber;

    public User(String userID, String password, int cardNumber) {
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

    public int getCardNumber() {
        return this.cardNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
