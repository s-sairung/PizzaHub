package chula.project.pizzahub.classes;


import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


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

    public static void saveProfile(Context context, Profile profile) {

        FileOutputStream fos = null;

        String userID = profile.getUserID() + System.getProperty("line.separator");
        String password = profile.getPassword() + System.getProperty("line.separator");
        String cardNo = profile.getCardNumber();

        try {
            fos = context.openFileOutput("profile.txt", MODE_PRIVATE);
            fos.write(userID.getBytes());
            fos.write(password.getBytes());
            fos.write(cardNo.getBytes());

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

    public static Profile loadProfile(Context context) {
        FileInputStream fis = null;

        Profile profile = new Profile();
        String[] array1 = new String[3];
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

    public static void addNewOrder(Context context, String stringInput) {
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
        string += stringInput;
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





    // ใช้ code 7 บรรทัดล่างในการอ่านไฟล์ได้

    //        InputStream input = getAssets().open("input.txt");
//        try {
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }

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
