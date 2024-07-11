package showroom.repository.mem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import showroom.model.Car;
import showroom.model.Showroom;
import showroom.repository.ShowroomDao;

import java.util.List;
import java.util.stream.Collectors;

@Repository("showroomDao")
//@Primary
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

    @Override
    public Showroom save(Showroom showroom) {
        int maxId = SampleData.showrooms.stream()
                .sorted((s1, s2) -> Integer.compare(s2.getId(), s1.getId()))
                .map(s->s.getId())
                .findFirst()
                .orElse(0);
        showroom.setId(maxId + 1);
        SampleData.showrooms.add(showroom);
        return showroom;
    }
}
