package chula.project.pizzahub.classes;

public class Profile {

    private String userID;
    private String password;
    private String cardNumber;
    private boolean isLogin = false;

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

    public boolean getLoginStatus() {
        return this.isLogin;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginStatus(boolean status) {
        this.isLogin = status;
    }

}