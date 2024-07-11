package showroom.repository;

import showroom.model.Car;
import showroom.model.Showroom;

import java.util.List;

public interface ShowroomDao {

    List<Showroom> findAll();

    Showroom findById(int id);

    List<Showroom> findByCar(Car car);

    Showroom save(Showroom showroom);
}
