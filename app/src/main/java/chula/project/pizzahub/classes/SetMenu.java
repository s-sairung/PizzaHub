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

    public ArrayList<Integer> getAllFoodAmount() {
        ArrayList<String> foodNames = this.getAllFoodName();
        ArrayList<Integer> foodAmount = new ArrayList<>();
        Food lastFood = new Food();
        int cnt = 0;
        if (!setMenu.isEmpty()) {
            for (Food food : setMenu) {
                if (!food.getName().equals(lastFood.getName())) {
                    cnt = 1; //ค้างไว้ตรงนี้
                }
                else {
                    cnt++;
                }
                lastFood = food;
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

    public int getFoodAmount() {
        return setMenu.size();
    }

    @Override
    public String toString() {
        return "SetMenu{" +
                "name='" + name + '\'' +
                ", setMenu=" + setMenu +
                ", price=" + price +
                '}';
    }
}
