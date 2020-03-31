package chula.project.pizzahub.classes;

public class PizzaHubMenuTester {

    public static void main(String[] args) {

        Menu drink1 = new Menu("Pepza 1.5L", 20.0);
        System.out.println(drink1.toString());

        Pizza pizza1 = new Pizza("Hawaiian Pizza", 279.0, "Hawaiian", "M", "Pan Medium");
        System.out.println(pizza1.toString());

    }

}
