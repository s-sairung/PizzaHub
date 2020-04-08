package chula.project.pizzahub.classes;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


import static android.content.Context.MODE_PRIVATE;


public class FileInteract {

    public static void saveLoginStatus(Context context, Boolean status) {

        FileOutputStream fos = null;

        try {
            fos = context.openFileOutput("loginStatus.txt", MODE_PRIVATE);
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
            fis = context.openFileInput("loginStatus.txt");
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



//    public static boolean getLoginStatus(Context context) {
//        InputStream file = null;
//        try {
//            boolean value = false;
//            file = context.getAssets().open("loginStatus.txt");
//            Scanner in = new Scanner(file);
//            if (in.hasNextLine()) {
//                value = Boolean.parseBoolean(in.nextLine());
//            }
//            file.close();
//            return value;
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }


//    public static String testLoginStatus(Context context) {
//
//        InputStream file = null;
//        try {
//            file = context.getAssets().open("loginStatus.txt");
//            Scanner in = new Scanner(file);
//                while (in.hasNextLine()) {
//                    if (in.nextLine().equals("[Login]")) {
//                        return in.nextLine();
//                    }
//            }
//            file.close();
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//        return "error";
//    }

}
