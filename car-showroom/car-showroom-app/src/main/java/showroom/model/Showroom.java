package showroom.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Showroom {
    private int id;
    private String name;
    private String logo;
    @JsonIgnore
    private List<Car> cars = new ArrayList<>();

    public Showroom() {}

    public Showroom(int id, String name, String logo) {
        this.id = id;
        this.name = name;
        this.logo = logo;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getLogo() { return logo; }

    public void setLogo(String logo) { this.logo = logo; }

    public List<Car> getCars() { return cars; }

    public void setCars(List<Car> cars) { this.cars = cars; }

    public void addCar(Car c) { this.cars.add(c); }

    @Override
    public String toString() {
        return "Showroom{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }

}
