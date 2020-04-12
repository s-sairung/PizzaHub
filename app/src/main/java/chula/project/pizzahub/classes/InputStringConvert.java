package chula.project.pizzahub.classes;

import java.util.ArrayList;
import java.util.Scanner;

public class InputStringConvert {

    public static String getAccount(String input) {
        String string = "";
        String line = "";
        boolean found = false;
        Scanner in = new Scanner(input);

        while (in.hasNextLine ()) {
            line = in.nextLine();
            if (line.contains("Account")) {
                found = true;
            }
            if (found) {
                string += line;
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        in.close();
        return string;
    }

    public static int getAccountCount(String accounts) {

        int count = 0;
        String line = "";
        Scanner in = new Scanner(accounts);

        while (in.hasNextLine ()) {
            line = in.nextLine();
            count++;
        }
        return count;
    }

    public static ArrayList<String[]> getAccountArrayList(String accounts) {
        ArrayList<String[]> accountArrayList = new ArrayList<>();
        String line = "";
        Scanner in = new Scanner(accounts);
        int accountNo = 1;
        while (in.hasNextLine ()) {
            line = in.nextLine();
            String curAccount = "Account " + accountNo + " : ";
            String lineReplaced = line.replace(curAccount, "");
            String[] acc = lineReplaced.split(", ");
            accountArrayList.add(acc);
            accountNo++;
        }
        in.close();
        return accountArrayList;
    }

}
