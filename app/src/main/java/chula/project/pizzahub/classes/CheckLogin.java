package chula.project.pizzahub.classes;


import android.content.Context;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class CheckLogin {

    public static boolean checkLogin(String userID, String password, Context context) throws FileNotFoundException {
        String input = FileInteract.readInputFile(context);
        String accounts = InputStringConvert.getAccount(input);
        int accountCnt = InputStringConvert.getAccountCount(accounts);
        ArrayList<String[]> accountList = InputStringConvert.getAccountArrayList(accounts);
        for (int i = 0; i < accountCnt; i++) {
            if (userID.equals(accountList.get(i)[0])) {
                if (password.equals(accountList.get(i)[1])) {
                    return true;
                }
            }
        }
        return false;
    }

}
