package showroom.repository.mem;

import showroom.model.Car;
import showroom.model.Manufacturer;
import showroom.model.Showroom;
import showroom.repository.CarDao;

import java.util.List;
import java.util.stream.Collectors;

public class MemCarDao implements CarDao {
    @Override
    public List<Car> findAll() {
        return SampleData.cars;
    }

    @Override
    public Car findById(int id) {
        return SampleData.cars.stream().filter(c -> c.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Car add(Car car) {
        int max = SampleData.cars.stream().max((c1, c2) -> c1.getId() - c2.getId()).get().getId();
        car.setId(++max);
        SampleData.cars.add(car);
        return car;
    }

    @Override
    public List<Car> findByManufacturer(Manufacturer manufacturer) {
        return SampleData.cars.stream().filter(c -> c.getManufacturer().equals(manufacturer)).collect(Collectors.toList());
    }

    @Override
    public List<Car> findByShowroom(Showroom showroom) {
        return SampleData.cars.stream().filter(c -> c.getShowrooms().equals(showroom)).collect(Collectors.toList());
    }
}
