package chula.project.pizzahub.classes;

public class Food {

    private String name;

    public Food(String name) {
        this.name = name;
    }

    public Food() {
        this("");
    }

    public String getName() {
        return name.trim();
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                '}';
    }
}
