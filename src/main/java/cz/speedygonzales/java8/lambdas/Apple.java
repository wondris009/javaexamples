package cz.speedygonzales.java8.lambdas;

/**
 * @author vondracek
 * @since 12.7.2016 8:35
 */
public class Apple {

    private String color;

    private int weight;

    public Apple() {

    }

    public Apple(String color, int weight) {

        this.color = color;
        this.weight = weight;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {

        this.color = color;
    }

    public int getWeight() {

        return weight;
    }

    public void setWeight(int weight) {

        this.weight = weight;
    }
}
