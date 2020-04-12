package chula.project.pizzahub.classes;

public class Menu {

    private String name;
    private double price;
    private int time;

    public Menu() {
        this("", 0.0, 0);
    }

    public Menu(String name, double price, int time) {
        this.name = name;
        this.price = price;
        this.time = time;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
