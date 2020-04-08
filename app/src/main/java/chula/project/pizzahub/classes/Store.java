package chula.project.pizzahub.classes;

import java.util.ArrayList;

public class Store {

    private int storeNumber;
    private int maxOrders;
    private ArrayList<Order> orders;

    public Store(int storeNumber, int maxOrders) {
        this.storeNumber = storeNumber;
        this.maxOrders = maxOrders;
    }



}
