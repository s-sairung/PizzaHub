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
                string += line.trim();
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

    public static String convertStar(String string) {
        String star = "";
        int length = string.length();
        for (int i = 0; i < length; i++) {
            star += "*";
        }
        return star;
    }

    public static String getStore(String input) {
        String string = "";
        String line = "";
        Scanner in = new Scanner(input);
        Scanner in2 = new Scanner(input);
        if (in2.hasNextLine()) {
            in2.nextLine();
        }
        while (in.hasNextLine()) {
            line = in.nextLine();
            string += line.trim();
            if (in2.hasNextLine()) {
                if (!in2.nextLine().equals("")) {
                    string += "\n";
                }
                else {
                    break;
                }
            }
        }
        in.close();
        return string;
    }

    public static int getStoreCount(String stores) {
        int count = 0;
        String line = "";
        Scanner in = new Scanner(stores);
        while (in.hasNextLine()) {
            line = in.nextLine();
            count++;
        }
        return count;
    }

    public static String getSimpleStore(String stores) {
        String storeString = "";
        String line = "";
        Scanner in = new Scanner(stores);
        int storeNo = 1;
        Scanner in2 = new Scanner(stores);
        if (in2.hasNextLine()) {
            in2.nextLine();
        }
        while (in.hasNextLine()) {
            line = in.nextLine();
            String curStore = "Store " + storeNo + ": ";
            String maxOrder = line.replace(curStore, "").replace("(", "").replace(")","");;
            storeString += "store" + storeNo + "\n";
            storeString += maxOrder;
            if (in2.hasNextLine()) {
                if (!in2.nextLine().equals("")) {
                    storeString += "\n";
                }
            }
            storeNo++;
        }
        in.close();
        return storeString;
    }

}
