package showroom.repository.mem;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import showroom.model.Manufacturer;
import showroom.repository.ManufacturerDao;

import java.util.List;

@Repository("manufacturerDao")
public class MemManufacturerDao implements ManufacturerDao {

    @Override
    public List<Manufacturer> findAll() {
        return SampleData.manufacturers;
    }

    @Override
    public Manufacturer findById(int id) {
        return SampleData.manufacturers.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Manufacturer add(Manufacturer manufacturer) {
        int max = SampleData.manufacturers.stream().max((m1, m2) -> m1.getId() - m2.getId()).get().getId();
        manufacturer.setId(++max);
        SampleData.manufacturers.add(manufacturer);
        return manufacturer;
    }
}
