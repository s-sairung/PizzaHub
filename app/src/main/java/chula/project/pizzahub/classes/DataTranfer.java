package chula.project.pizzahub.classes;

import java.io.Serializable;

public class DataTranfer implements Serializable {

    private Users users;
    private Profile profile;

    public DataTranfer(Users users, Profile profile) {
        this.users = users;
        this.profile = profile;
    }

    public Users getUsers() {
        return users;
    }

    public Profile getProfile() {
        return profile;
    }
}
