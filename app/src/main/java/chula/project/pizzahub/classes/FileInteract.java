package chula.project.pizzahub.classes;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


import static android.content.Context.MODE_PRIVATE;


public class FileInteract {

    public static void saveLoginStatus(Context context, Boolean status) {

        FileOutputStream fos = null;

        try {
            fos = context.openFileOutput("loginstatus.txt", MODE_PRIVATE);
            fos.write(status.toString().getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String loadLoginStatus(Context context) {
        FileInputStream fis = null;
        String output = "";

        try {
            fis = context.openFileInput("loginstatus.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text);
            }

            output = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return output;
    }

    public static void saveProfile(Context context, Profile profile) {

        FileOutputStream fos = null;

        String userID = profile.getUserID() + System.getProperty("line.separator");
        String password = profile.getPassword() + System.getProperty("line.separator");
        String cardNo = profile.getCardNumber() + System.getProperty("line.separator");
        String image = 0+"";

        try {
            fos = context.openFileOutput("profile.txt", MODE_PRIVATE);
            fos.write(userID.getBytes());
            fos.write(password.getBytes());
            fos.write(cardNo.getBytes());
            fos.write(image.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void saveProfilePicture(Context context, Profile profile, int pickedImage) {

        FileOutputStream fos = null;

        String userID = profile.getUserID() + System.getProperty("line.separator");
        String password = profile.getPassword() + System.getProperty("line.separator");
        String cardNo = profile.getCardNumber() + System.getProperty("line.separator");
        String image = pickedImage+"";

        try {
            fos = context.openFileOutput("profile.txt", MODE_PRIVATE);
            fos.write(userID.getBytes());
            fos.write(password.getBytes());
            fos.write(cardNo.getBytes());
            fos.write(image.getBytes());

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int loadProfilePicture(Context context) {
        FileInputStream fis = null;
        int pickedImage = 0;
        String string = "";

        try {
            fis = context.openFileInput("profile.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
            }
            string = sb.toString();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        string = string.trim();
        String[] lines = string.split("\n");
        return Integer.parseInt(lines[3]);
    }

    public static Profile loadProfile(Context context) {
        FileInputStream fis = null;

        Profile profile = new Profile();
        String[] array1 = new String[4];
        int arrayNo = 0;

        try {
            fis = context.openFileInput("profile.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null) {
                sb.append(text).append("\n");
                array1[arrayNo] = text;
                arrayNo++;
            }

            profile.setUserID(array1[0]);
            profile.setPassword(array1[1]);
            profile.setCardNumber(array1[2]);
//            output = sb.toString();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return profile;
    }

    public static void clearProfile(Context context) {
        String string = "";
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("profile.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readInputFile(Context context) {
        String string = "";
        InputStream input = null;
        try {
            input = context.getAssets().open("input.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine ()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string;
    }

    public static void saveAllStore(Context context, String stores) {
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("stores.txt", MODE_PRIVATE);
            fos.write(stores.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void addNewOrder(Context context, SetMenu setMenu) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("order.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        string = string.trim();
        string += "\n";
        string += "\n";
        string += InputStringConvert.getSetMenuString(InputStringConvert.getSetMenu(FileInteract.readInputFile(context)), setMenu.getName());
        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("order.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void addNewOrder(Context context, String newOrderInput) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("order.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        string = string.trim();
        string += "\n";
        string += "\n";
        string += newOrderInput;
        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("order.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void removeOrder(Context context, String[] curOrderArray, int index) {
        String string = "";
        curOrderArray[index] = "";
        for (String order : curOrderArray) {
            string += order;
            string = string.trim();
            string += "\n";
        }

        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("order.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readRawOrderFile(Context context) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("order.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string.trim();
    }

    public static void clearOrder(Context context) {
        String string = "";
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("order.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void addNewHistory(Context context, String rawOrder, double orderPrice, String date, String receiptNumber) {
        if (rawOrder.isEmpty()) return;
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("history.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        string = string.trim();
        if (!string.isEmpty()) {
            string += "\n";
            string += "--next-order--";
            string += "\n";
        }
        string += rawOrder.trim();
        string += "\n";
        string += "Price:";
        string += orderPrice;
        string += "\n";
        string += "Date:";
        string += date;
        string += "\n";
        string += "Receipt:";
        string += receiptNumber;

        string += "\n";
        string += "OrderNumber:";
        addOrderCount(context);
        int orderNumber = getOrderCount(context);
        string += orderNumber;

        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("history.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void removeHistory(Context context, String[] curHistoryArray, int index) {
        String string = "";
        curHistoryArray[index] = "";
        string += curHistoryArray[0];
        string = string.trim();
        for (int i = 1; i < curHistoryArray.length; i++) {
            if (!curHistoryArray[i].isEmpty()) {
                string += "\n";
                string += "--next-order--";
                string += "\n";
                string += curHistoryArray[i].trim();
            }
        }

        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("history.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void clearHistory(Context context) {
        String string = "";
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("history.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readRawHistoryFile(Context context) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("history.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string.trim();
    }

    public static void addNewReceiptNumber(Context context, String receiptNumber) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("receiptno.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        string = string.trim();
        string += "\n";
        string += receiptNumber;
        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("receiptno.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void removeReceiptNumber(Context context, String[] curReceiptNumberArray, int index) {
        String string = "";
        curReceiptNumberArray[index] = "";
        for (String number : curReceiptNumberArray) {
            string += number;
            string = string.trim();
            string += "\n";
        }

        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("receiptno.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void clearReceiptNumber(Context context) {
        String string = "";
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("receiptno.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readRawReceiptNumberFile(Context context) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("receiptno.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string.trim();
    }

    public static void writeReceiptFile(Context context, String order) {
        order = order.trim();
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("receipt.txt", MODE_PRIVATE);
            fos.write(order.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readReceiptFile(Context context) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("receipt.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string.trim();
    }

    public static int getOrderCount(Context context) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("ordercnt.txt");
            Scanner in = new Scanner(input);
            string = in.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        int cnt = Integer.parseInt(string.trim());
        return cnt;
    }

    public static void addOrderCount(Context context) {
        int cnt = getOrderCount(context);
        cnt++;
        String cntString = cnt + "";
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("ordercnt.txt", MODE_PRIVATE);
            fos.write(cntString.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void resetOrderCount(Context context) {
        String string = "0";
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("ordercnt.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void addNewCancelled(Context context, String processedHistory) {
        if (processedHistory.isEmpty()) return;
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("cancelled.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        string = string.trim();
        if (!string.isEmpty()) {
            string += "\n";
            string += "--next-order--";
            string += "\n";
        }
        string += processedHistory.trim();
        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("cancelled.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void clearCancelled(Context context) {
        String string = "";
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("cancelled.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readRawCancelledFile(Context context) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("cancelled.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string.trim();
    }

    public static void writeAccountsFileFromInput(Context context) {
        ArrayList<String[]> accounts = InputStringConvert.getAccountArrayList(InputStringConvert.getAccount(readInputFile(context)));
        if (accounts.isEmpty()) return;

        String string = "";

        string += accounts.get(0)[0].trim();
        string += "\n";
        string += accounts.get(0)[1].trim();

        for (int i = 1; i < accounts.size(); i++) {
            string += "\n";
            string += "--next-account--";
            string += "\n";
            string += accounts.get(i)[0].trim();
            string += "\n";
            string += accounts.get(i)[1].trim();
        }

        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("inputaccounts.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readRawInputAccountsFile(Context context) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("inputaccounts.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string.trim();
    }

    public static void addNewUserAccount(Context context, Profile profile) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("useraccounts.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        string = string.trim();
        if (!string.isEmpty()) {
            string += "\n";
            string += "--next-account--";
            string += "\n";
        }

        string += profile.getUserID();
        string += "\n";
        string += profile.getPassword();
        string += "\n";
        string += profile.getCardNumber();
        string = string.trim();

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("useraccounts.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void clearUserAccounts(Context context) {
        String string = "";
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput("useraccounts.txt", MODE_PRIVATE);
            fos.write(string.getBytes());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (fos != null) {
                try {
                    fos.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String readRawUserAccountsFile(Context context) {
        String string = "";
        InputStream input = null;
        try {
            input = context.openFileInput("useraccounts.txt");
            Scanner in = new Scanner(input);
            while (in.hasNextLine()) {
                string += in.nextLine();
                if (in.hasNextLine()) {
                    string += "\n";
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return string.trim();
    }

}
