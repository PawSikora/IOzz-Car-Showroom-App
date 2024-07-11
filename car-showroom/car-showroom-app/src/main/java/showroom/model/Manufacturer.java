package showroom.model;

import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    private int id;
    private String name;
    private String country;
    private List<Car> cars = new ArrayList<>();

    public Manufacturer() {}

    public Manufacturer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public List<Car> getCars() { return cars; }

    public void setCars(List<Car> cars) { this.cars = cars; }

    public void addCar(Car c) { this.cars.add(c); }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
