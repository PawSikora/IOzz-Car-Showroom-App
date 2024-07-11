package showroom.service;

import showroom.model.Car;
import showroom.model.Manufacturer;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getCarsByManufacturer(Manufacturer manufacturer);

    Car getCarById(int id);

    Car addCar(Car car);


    List<Manufacturer> getAllManufacturers();

    Manufacturer getManufacturerById(int id);

    Manufacturer addManufacturer(Manufacturer manufacturer);
}
