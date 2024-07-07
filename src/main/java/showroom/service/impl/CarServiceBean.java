package showroom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import showroom.model.Car;
import showroom.model.Manufacturer;
import showroom.model.Showroom;
import showroom.repository.CarDao;
import showroom.repository.ManufacturerDao;
import showroom.repository.ShowroomDao;
import showroom.service.CarService;

import java.util.List;
import java.util.logging.Logger;

@Component
public class CarServiceBean implements CarService {

    private  static final Logger log = Logger.getLogger(CarService.class.getName());

    private CarDao carDao;
    private ManufacturerDao manufacturerDao;
    private ShowroomDao showroomDao;

    @Autowired
    public void setManufacturerDao(ManufacturerDao manufacturerDao) {
        this.manufacturerDao = manufacturerDao;
    }

    public CarServiceBean(CarDao carDao, ManufacturerDao manufacturerDao, ShowroomDao showroomDao) {
        log.info("creating car service bean");
        this.carDao = carDao;
        this.manufacturerDao = manufacturerDao;
        this.showroomDao = showroomDao;
    }

    @Override
    public List<Car> getAllCars() {
        log.info("searching all cars");
        return carDao.findAll();
    }

    public List<Car> getCarsByShowroom(Showroom showroom) {
        log.info("searching cars by showroom " + showroom.getId());
        return carDao.findByShowroom(showroom);
    }

    @Override
    public Car getCarById(int id) {
        log.info("searching car by id " + id);
        return carDao.findById(id);
    }

    @Override
    public Car addCar(Car car) {
        log.info("adding car " + car.getId());
        return carDao.add(car);
    }

    @Override
    public List<Car> getCarsByManufacturer(Manufacturer manufacturer) {
        log.info("searching cars by manufacturer " + manufacturer.getId());
        return carDao.findByManufacturer(manufacturer);
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {
        log.info("searching all manufacturers");
        return manufacturerDao.findAll();
    }

    @Override
    public Manufacturer getManufacturerById(int id) {
        log.info("searching manufacturer by id " + id);
        return manufacturerDao.findById(id);
    }

    @Override
    public Manufacturer addManufacturer(Manufacturer manufacturer) {
        log.info("adding manufacturer " + manufacturer.getId());
        return manufacturerDao.add(manufacturer);
    }

    public  List<Showroom> getAllShowrooms() {
        log.info("searching all showrooms");
        return showroomDao.findAll();
    }

    public Showroom getShowroomById(int id) {
        log.info("searching showroom by id " + id);
        return showroomDao.findById(id);
    }

    public List<Car> getCarsInShowroom(Showroom showroom) {
        log.info("searching cars in showroom " + showroom.getId());
        return carDao.findByShowroom(showroom);
    }


}
