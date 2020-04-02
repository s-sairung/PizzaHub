package chula.project.pizzahub.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Users implements Serializable {

    private boolean isLogin = false;
    private ArrayList<Profile> profilesList;

    public Users() {
        profilesList = new ArrayList<Profile>();
    }

    public void addProfile(Profile profile) {
        profilesList.add(profile);
    }

    public ArrayList<Profile> getProfilesList() {
        return profilesList;
    }

}
