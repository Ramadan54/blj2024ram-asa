package noseryoung.ch.carshopbackend.car;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByMakeIgnoreCaseContainingOrModelIgnoreCaseContaining(String make, String model);
}