package showroom.service;

import showroom.model.Car;
import showroom.model.Manufacturer;
import showroom.model.Showroom;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getCarsByManufacturer(Manufacturer manufacturer);
    List<Car> getCarsInShowroom(Showroom showroom);

    Car getCarById(int id);

    Car addCar(Car car);


    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerById(int id);

    Manufacturer addManufacturer(Manufacturer manufacturer);
}
