package showroom.model;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private int id;
    private String name;
    private String carImage;
    private Manufacturer manufacturer;
    private int year;
    private int price;
    private List<Showroom> showrooms = new ArrayList<>();

    public Car() {}

    public Car(int id, String name, String carImage, Manufacturer manufacturer, int year, int price) {
        this.id = id;
        this.name = name;
        this.carImage = carImage;
        this.manufacturer = manufacturer;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarImage() { return carImage; }

    public void setCarImage(String carImage) { this.carImage = carImage; }

    public Manufacturer getManufacturer() { return manufacturer; }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Showroom> getShowrooms() {
        return showrooms;
    }

    public void setShowrooms(List<Showroom> showrooms) { this.showrooms = showrooms; }

    public void addShowroom(Showroom s) { this.showrooms.add(s); }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer=" + manufacturer +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
