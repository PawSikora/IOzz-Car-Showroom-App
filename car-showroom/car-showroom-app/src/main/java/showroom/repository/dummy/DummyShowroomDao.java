package showroom.repository.dummy;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import showroom.model.Car;
import showroom.model.Showroom;
import showroom.repository.ShowroomDao;

import java.util.List;

@Component
//@Primary
public class DummyShowroomDao implements ShowroomDao {
    @Override
    public List<Showroom> findAll() {
        return List.of();
    }

    @Override
    public Showroom findById(int id) {
        return null;
    }

    @Override
    public List<Showroom> findByCar(Car car) {
        return List.of();
    }

    @Override
    public Showroom save(Showroom showroom) { return null; }
}
