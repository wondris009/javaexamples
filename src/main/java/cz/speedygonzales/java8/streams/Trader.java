package cz.speedygonzales.java8.streams;

/**
 * @author vondracek
 * @since 17.10.2016 17:43
 */
public class Trader {

    private String name;

    private String city;

    public Trader(String name, String city) {

        this.name = name;
        this.city = city;
    }

    public String getName() {

        return name;
    }

    public String getCity() {

        return city;
    }

    @Override
    public String toString() {

        return "Trader{" + "name='" + name + '\'' + ", city='" + city + '\'' + '}';
    }
}
