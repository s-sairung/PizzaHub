package chula.project.pizzahub.classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Users {

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

    public boolean isInUsers(Profile profile) {
        for (Profile profileSearch : profilesList) {
            if (profileSearch.equals(profile)) {
                return true;
            }
        }
        return false;
    }

    public int getIndex(Profile profile) {
        for (int i = 0; i < profilesList.size(); i++) {
            if (profile.equals(profilesList.get(i))) {
                return i;
            }
        }
        return 0;
    }

}
