package showroom.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import showroom.model.Car;
import showroom.model.Showroom;
import showroom.repository.CarDao;
import showroom.repository.ShowroomDao;
import showroom.service.ShowroomService;

import java.util.List;
import java.util.logging.Logger;

@Service
@Scope("prototype")
public class ShowroomServiceBean implements ShowroomService {

    private static final Logger log = Logger.getLogger(ShowroomService.class.getName());

    private ShowroomDao showroomDao;
    private CarDao carDao;

    @Autowired
    public ShowroomServiceBean(ShowroomDao showroomDao, CarDao carDao) {
        log.info("creating showroom service bean");
        this.showroomDao = showroomDao;
        this.carDao = carDao;
    }

    @Override
    public Showroom getShowroomById(int id) {
        log.info("searching showroom by id " + id);
        return showroomDao.findById(id);
    }

    @Override
    public List<Showroom> getAllShowrooms() {
        log.info("searching all showrooms");
        return showroomDao.findAll();
    }

    @Override
    public List<Showroom> getShowroomsByCar(Car car) {
        log.info("searching showrooms by car " + car.getId());
        return showroomDao.findByCar(car);
    }

    @Override
    public List<Car> getCarsInShowroom(Showroom showroom) {
        log.info("searching cars in showroom " + showroom.getId());
        return carDao.findByShowroom(showroom);
    }

    @Override
    public Showroom addShowroom(Showroom showroom) {
        log.info("adding new showroom " + showroom.getName());
        return showroomDao.save(showroom);
    }
}

