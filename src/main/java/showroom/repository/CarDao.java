package showroom.repository;

import showroom.model.Car;
import showroom.model.Manufacturer;
import showroom.model.Showroom;

import java.util.List;

public interface CarDao {

    List<Car> findAll();

    Car findById(int id);

    List<Car> findByManufacturer(Manufacturer manufacturer);

    List<Car> findByShowroom(Showroom showroom);

    Car add(Car car);
}
