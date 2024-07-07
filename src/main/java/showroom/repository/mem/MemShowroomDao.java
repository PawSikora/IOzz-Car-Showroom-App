package showroom.repository.mem;

import showroom.model.Car;
import showroom.model.Showroom;
import showroom.repository.ShowroomDao;

import java.util.List;
import java.util.stream.Collectors;

public class MemShowroomDao implements ShowroomDao {

    @Override
    public List<Showroom> findAll() {
        return SampleData.showrooms;
    }

    @Override
    public Showroom findById(int id) {
        return SampleData.showrooms.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Showroom> findByCar(Car car) {
        return SampleData.showrooms.stream().filter(s -> s.getCars().contains(car)).collect(Collectors.toList());
    }
}
