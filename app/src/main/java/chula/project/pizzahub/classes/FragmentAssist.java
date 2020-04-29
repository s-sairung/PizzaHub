package chula.project.pizzahub.classes;


import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FragmentAssist {

    public static boolean checkLogin(String userID, String password, Context context) {
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

    public static boolean authenticate(String userID, String password, Context context) {
        String[] userAccounts = InputStringConvert.getAccountsArray(FileInteract.readRawUserAccountsFile(context));
        String[] inputAccounts = InputStringConvert.getAccountsArray(FileInteract.readRawInputAccountsFile(context));
        ArrayList<String[]> accountsList = new ArrayList<>();
        for (int i = 0; i < userAccounts.length; i++) {
            accountsList.add(userAccounts[i].trim().split("\n"));
        }
        for (int i = 0; i < inputAccounts.length; i++) {
            accountsList.add(inputAccounts[i].trim().split("\n"));
        }

        //0 = userID
        //1 = password

        for (int i = 0; i < accountsList.size(); i++) {
            if (userID.equals(accountsList.get(i)[0])) {
                if (password.equals(accountsList.get(i)[1])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String receiptNumberGenerator(Context context) {
        String[] processedReceiptNumbers = InputStringConvert.getReceiptNumberArray(FileInteract.readRawReceiptNumberFile(context));
        String receipt = genReceipt();
        List<String> list = Arrays.asList(processedReceiptNumbers);
        while (list.contains(receipt)) {
            receipt = genReceipt();
        }
        return receipt;
    }

    private static String genReceipt() {
        final String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String numbers = "0123456789";
        String receiptNo = "";
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            char c = alphabets.charAt(rand.nextInt(26));
            receiptNo += c;
        }
        for (int i = 0; i < 3; i++) {
            char c = numbers.charAt(rand.nextInt(10));
            receiptNo += c;
        }
        for (int i = 0; i < 2; i++) {
            char c = alphabets.charAt(rand.nextInt(26));
            receiptNo += c;
        }
        return receiptNo;
    }

}
