package noseryoung.ch.carshopbackend.car;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService {

    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }
    public List<Car> list(String q) {
        if (q == null || q.isBlank()) {
            return repo.findAll();
        }
        return repo.findByMakeIgnoreCaseContainingOrModelIgnoreCaseContaining(q, q);
    }
    public Car get(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Car not found: " + id));
    }
    public Car create(CarDto dto) {
        Car c = new Car();
        c.setMake(dto.make());
        c.setModel(dto.model());
        c.setYear(dto.year());
        c.setPrice(dto.price());
        c.setStock(dto.stock());
        c.setImageUrl(dto.imageUrl());
        return repo.save(c);
    }
    public Car update(Long id, CarDto dto) {
        Car c = get(id);
        c.setMake(dto.make());
        c.setModel(dto.model());
        c.setYear(dto.year());
        c.setPrice(dto.price());
        c.setStock(dto.stock());
        c.setImageUrl(dto.imageUrl());
        return repo.save(c);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}