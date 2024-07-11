package showroom.service;

import showroom.model.Car;
import showroom.model.Showroom;

import java.util.List;

public interface ShowroomService {

    Showroom getShowroomById(int id);

    List<Showroom> getAllShowrooms();

    List<Showroom> getShowroomsByCar(Car car);

    List<Car> getCarsInShowroom(Showroom showroom);
}
