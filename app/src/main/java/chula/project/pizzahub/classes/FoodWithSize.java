package chula.project.pizzahub.classes;

import java.util.ArrayList;

public class FoodWithSize extends Food {

    private ArrayList<String[]> size; //0 - sizeName, 1 - time, 2 - price

    public FoodWithSize(String name) {
        super(name);
        size = new ArrayList<>();
    }

    public void addSize(String sizeName, int time, double price) {
        String[] size = {sizeName, time+"", price+""};
        this.size.add(size);
    }

    public ArrayList<String[]> getSizeArrayList() {
        return size;
    }

    public String[] getSizeNameArray() {
        String[] sizeNameArray = new String[size.size()];
        for (int i = 0; i < size.size(); i++) {
            sizeNameArray[i] = size.get(i)[0];
        }
        return sizeNameArray;
    }

    public int getTime(String sizeName) {
        for (String[] size : this.size) {
            if (sizeName.equals(size[0])) {
                return Integer.parseInt(size[1]);
            }
        }
        return 0;
    }

    public double getPrice(String sizeName) {
        for (String[] size : this.size) {
            if (sizeName.equals(size[0])) {
                return Double.parseDouble(size[2]);
            }
        }
        return 0.0;
    }

    @Override
    public String toString() {
        return "FoodWithSize{" +
                "size=" + size +
                "} " + super.toString();
    }
}
