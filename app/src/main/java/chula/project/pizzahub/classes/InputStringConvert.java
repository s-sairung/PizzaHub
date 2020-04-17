package chula.project.pizzahub.classes;

import java.util.ArrayList;
import java.util.Collections;
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
        in2.close();
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
        in2.close();
        return storeString;
    }

    public static String getCategories(String input) {
        String string = "";
        String line = "";
        String line2 = "";
        boolean found = false;
        Scanner in = new Scanner(input);
        Scanner in2 = new Scanner(input);
        if (in2.hasNextLine()) {
            in2.nextLine();
        }
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (in2.hasNextLine()) {
                line2 = in2.nextLine();
            }
            if (line.contains("Category")) {
                found = true;
            }
            if (found) {
                string += line.trim();
                if (!line2.equals("")) {
                    string += "\n";
                }
                else {
                    break;
                }
            }
        }
        in.close();
        in2.close();
        return string;
    }

    public static ArrayList<String> getMainCategoriesArrayList(String category) {
        String string = "";
        String line = "";
        ArrayList<String> categories = new ArrayList<>();
        Scanner in = new Scanner(category);
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (line.contains("Category: ")) {
                line = line.replace("Category: ", "");
                String[] cats = line.split(", ");
                Collections.addAll(categories, cats);
                break;
            }
        }
        in.close();
        return categories;
    }

    public static ArrayList<String> getOtherCategoriesArrayList(String category) {
        String string = "";
        String line = "";
        ArrayList<String> categories = new ArrayList<>();
        Scanner in = new Scanner(category);
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (line.contains("Category Others: ")) {
                line = line.replace("Category Others: ", "");
                String[] cats = line.split(", ");
                Collections.addAll(categories, cats);
                break;
            }
        }
        in.close();
        return categories;
    }

    public static String getSpecificFood(String food, String foodType) {
        foodType += ": ";
        String string = "";
        String line = "";
        String line2 = "";
        boolean found = false;
        boolean hasSize = false;
        Scanner in = new Scanner(food);
        Scanner in2 = new Scanner(food);
        if (in2.hasNextLine()) {
            in2.nextLine();
        }
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (in2.hasNextLine()) {
                line2 = in2.nextLine();
            }
            if (line.contains(foodType)) {
                found = true;
            }
            if (found) {
                string += line.trim();
                if (!line2.contains(":")) {
                    string += "\n";
                }
                else {
                    break;
                }
            }
        }
        in.close();
        in2.close();

        string = string.replace(foodType, "");

        return string.trim();
    }

    public static ArrayList<Food> getSpecificFoodArrayList(String specificFood) {

        ArrayList<Food> foodArrayList = new ArrayList<>();
        boolean hasSize = false;
        Scanner in = new Scanner(specificFood);
        String line = in.nextLine();
        String line2 = "";
        if (in.hasNextLine()) {
            hasSize = true;
            line2 = in.nextLine();
        }
        in.close();

        if (!hasSize) {
            String[] split = line.split(", ");
            for (String food : split) {
                String[] split2 = food.split(" ");
                //0 เป็นชื่ออาหาร
                //1 เป็นเวลากับราคา (เวลา,Bราคา)
                String name = split2[0];
                String foodProperty = split2[1];
                foodProperty = foodProperty.replace("(", "").replace(")", "");
                String[] split3 = foodProperty.split(",");
                //0 เป็นเวลา
                //1 เป็นราคา
                int time = Integer.parseInt(split3[0]);
                double price = Double.parseDouble(split3[1].replace("B",""));
                FoodNoSize foodTemp = new FoodNoSize(name, time, price);
                foodArrayList.add(foodTemp);
            }
        }
        else {
            String[] splitFoodName = line.split(", ");
            String[] splitFoodProperties = line2.split(", ");
            for (int i = 0; i < splitFoodName.length; i++) {
                String foodName = splitFoodName[i];
                for (int j = 0; j < splitFoodProperties.length; j++) {
                    String[] split2 = splitFoodProperties[j].split(" ");
                    //0 เป็น sizeName
                    //1 เป็นเวลากับราคา (เวลา,Bราคา)
                    String sizeName = split2[0];
                    String foodTimeAndPrice = split2[1];
                    foodTimeAndPrice = foodTimeAndPrice.replace("(", "").replace(")", "");
                    String[] split3 = foodTimeAndPrice.split(",");
                    //0 เป็นเวลา
                    //1 เป็นราคา
                    int time = Integer.parseInt(split3[0]);
                    double price = Double.parseDouble(split3[1].replace("B",""));
                    if (foodArrayList.isEmpty()) {
                        FoodWithSize foodWithSize = new FoodWithSize(foodName);
                        foodWithSize.addSize(sizeName, time, price);
                        foodArrayList.add(foodWithSize);
                    }
                    else {
                        boolean foundName = false;
                        for (Food food : foodArrayList) {
                            FoodWithSize food1 = (FoodWithSize) food;
                            if (food1.getName().equals(foodName)) {
                                food1.addSize(sizeName, time, price);
                                foundName = true;
                                break;
                            }
                        }
                        if (!foundName) {
                            FoodWithSize foodWithSize = new FoodWithSize(foodName);
                            foodWithSize.addSize(sizeName, time, price);
                            foodArrayList.add(foodWithSize);
                        }
                    }
                }
            }
        }
        return foodArrayList;
    }

    public static SetMenu getFlashDealSetMenu(String setMenu) {
        String line = "";
        SetMenu set = new SetMenu("Flash Deal");
        Scanner in = new Scanner(setMenu);
        Scanner in2 = new Scanner(setMenu);
        if (in2.hasNextLine()) {
            in2.nextLine();
        }
        boolean ended = false;
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (in2.hasNextLine()) {
                if (in2.nextLine().equals("")) {
                    ended = true;
                }
            }
            if (line.equals("Flash Deal:")) {
                continue;
            }
            if (!ended) {
                line = line.trim().replace(",", "");
                String[] food = line.split(" ");
                if (food.length == 2) {
                    int amount = Integer.parseInt(food[1].replace("x", ""));
                    for (int i = 1; i <= amount; i++) {
                        FoodNoSize fns = new FoodNoSize(food[0]);
                        set.addFood(fns);
                    }
                }
                else if (food.length == 3) {
                    int amount = Integer.parseInt(food[2].replace("x", ""));
                    for (int i = 1; i <= amount; i++) {
                        FoodWithSize fws = new FoodWithSize(food[0]);
                        fws.addSize(food[1]);
                        set.addFood(fws);
                    }
                }
            }
            else {
                line = line.replace("B", "").trim();
                set.setPrice(Double.parseDouble(line));
                break;
            }
        }
        return set;
    }

    public static String getFlashDealString(String setMenu) {
        String line = "";
        String string = "";
        Scanner in = new Scanner(setMenu);
        Scanner in2 = new Scanner(setMenu);
        if (in2.hasNextLine()) {
            in2.nextLine();
        }
        boolean ended = false;
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (in2.hasNextLine()) {
                if (in2.nextLine().equals("")) {
                    ended = true;
                }
            }
            if (!ended) {
                string += line;
                string += "\n";
            }
            else {
                string += line;
                break;
            }
        }
        return string.trim();
    }

    public static String getSetMenu(String input) {
        String string = "";
        String line = "";
        String line2 = "";
        boolean found = false;
        Scanner in = new Scanner(input);
        Scanner in2 = new Scanner(input);
        if (in2.hasNextLine()) {
            in2.nextLine();
        }
        while (in.hasNextLine()) {
            line = in.nextLine();
            if (in2.hasNextLine()) {
                line2 = in2.nextLine();
                if (line2.contains("Account")) {
                    break;
                }
            }
            if (line.contains("Set Menu")) {
                found = true;
                line = line.replace("Set Menu", "");
            }
            if (found) {
                string += line.trim();
                string += "\n";
            }
        }
        in.close();
        in2.close();
        return string.trim();
    }

}
