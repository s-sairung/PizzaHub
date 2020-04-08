package chula.project.pizzahub.classes;

import java.util.ArrayList;

public class Order {

    private ArrayList<Menu> menuArrayList;
    private int orderNumber;
    private static int orderNumberCount = 0;

    public Order() {
        this.menuArrayList = new ArrayList<>();
        orderNumberCount++;
        this.orderNumber = orderNumberCount;
    }

    public int getOrderNumber() {
        return orderNumber;
    }



}
