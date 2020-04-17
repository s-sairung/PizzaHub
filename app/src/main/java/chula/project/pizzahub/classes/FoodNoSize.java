package chula.project.pizzahub.classes;

public class FoodNoSize extends Food {

    private int time;
    private double price;

    public FoodNoSize(String name, int time, double price) {
        super(name);
        this.time = time;
        this.price = price;
    }

    public FoodNoSize(String name) {
        this(name, 0, 0.0);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toOrder() {
        return "Food:" + "\n" + this.getName() + "\nB" + (int) this.getPrice();
    }

    public String toButton() {
        return this.getName() + "\nB" + (int) this.getPrice();
    }

    @Override
    public String toString() {
        return "FoodNoSize{" +
                "time=" + time +
                ", price=" + price +
                "} " + super.toString();
    }
}
