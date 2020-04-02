package chula.project.pizzahub.classes;

import java.util.ArrayList;

public class Users {

    private boolean isLogin = false;
    private ArrayList<Profile> profilesList;

    public Users(Profile profile) {
        profilesList = new ArrayList<Profile>();
    }

    public void addProfile(Profile profile) {
        profilesList.add(profile);
    }

    public ArrayList<Profile> getProfilesList() {
        return profilesList;
    }

}
