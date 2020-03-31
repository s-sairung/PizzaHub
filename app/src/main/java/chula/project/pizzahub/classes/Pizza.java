package chula.project.pizzahub.classes;

public class Pizza extends Menu {

    private String topping;
    private String crust;
    private String size;

    public Pizza() {
        this("", 0.0, "", "", "");
    }

    public Pizza(String name, double price, String topping, String crust, String size) {
        super(name, price);
        this.topping = topping;
        this.crust = crust;
        this.size = size;
    }

    public String getTopping() {
        return this.topping;
    }

    public String getCrust() {
        return this.crust;
    }

    public String size() {
        return this.size;
    }

    @Override
    public String toString() {
        return super.toString() + "\n[topping=" + this.topping + ",crust=" + this.crust + ",size=" + this.size + "]";
    }

}
