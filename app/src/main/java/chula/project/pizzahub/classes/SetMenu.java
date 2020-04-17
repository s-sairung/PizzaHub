package chula.project.pizzahub.classes;

import java.util.ArrayList;

public class SetMenu {

    private String name;
    private ArrayList<Food> setMenu;
    private double price;

    public SetMenu(String name, double price) {
        this.name = name;
        this.price = price;
        setMenu = new ArrayList<>();
    }

    public SetMenu(String name) {
        this(name, 0.0);
    }

    public SetMenu() {
        this("", 0.0);
    }

    public void addFood(Food f) {
        setMenu.add(f);
    }

    public ArrayList<Food> getSetMenu() {
        return setMenu;
    }

    public ArrayList<String> getAllFoodName() {
        ArrayList<String> foodNames = new ArrayList<>();
        if (!setMenu.isEmpty()) {
            for (Food food : setMenu) {
                foodNames.add(food.getName());
            }
        }
        return foodNames;
    }

    public ArrayList<String> getFoodNameNoDup() {
        ArrayList<String> foodNames = this.getAllFoodName();
        int size = foodNames.size();
        foodNames.add("temp");
        ArrayList<String> foodNamesNoDup = new ArrayList<>();
        if (!setMenu.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (!foodNames.get(i).equals(foodNames.get(i + 1))) {
                    foodNamesNoDup.add(foodNames.get(i));
                }
            }
        }
        return foodNamesNoDup;
    }

    public ArrayList<String> getFoodSizeNoDup() {
        ArrayList<String> foodNamesNoDup = this.getFoodNameNoDup();
        ArrayList<String> foodSizeNoDup = new ArrayList<>();
        if (!setMenu.isEmpty()) {
            for (int i = 0; i < foodNamesNoDup.size(); i++) {
                for (Food food : setMenu) {
                    if (food instanceof FoodWithSize) {
                        FoodWithSize fws = (FoodWithSize) food;
                        if (foodNamesNoDup.get(i).equals(fws.getName())) {
                            foodSizeNoDup.add(fws.getSizeNameArray()[0]);
                            break;
                        }
                    }
                    else {
                        foodSizeNoDup.add("");
                    }
                }
            }
        }
        return foodSizeNoDup;
    }

    public ArrayList<Integer> getAllFoodAmount() {
        ArrayList<String> foodNames = this.getAllFoodName();
        int size = foodNames.size();
        foodNames.add("temp");
        ArrayList<Integer> foodAmount = new ArrayList<>();
        int cnt = 1;
        if (!setMenu.isEmpty()) {
            for (int i = 0; i < size; i++) {
                if (foodNames.get(i).equals(foodNames.get(i+1))) {
                    cnt++;
                }
                else {
                    foodAmount.add(cnt);
                    cnt = 1;
                }
            }
        }
        return foodAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getFoodArrayListSize() {
        return setMenu.size();
    }

    @Override
    public String toString() {
        ArrayList<String> names = this.getFoodNameNoDup();
        ArrayList<String> size = this.getFoodSizeNoDup();
        ArrayList<Integer> amount = this.getAllFoodAmount();
        String string = "";
        for (int i = 0; i < names.size(); i++) {
            String line = names.get(i) + " " + size.get(i);
            line = line.trim();
            line += " x" + amount.get(i);
            string += line;
            string += "\n";
        }
        return string.trim();
    }

}
