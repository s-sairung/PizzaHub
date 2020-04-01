package chula.project.pizzahub.classes;

public class Profile {

    private boolean isLogin = false;
    private User user;

    public Profile(User user) {
        this.isLogin = true;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
