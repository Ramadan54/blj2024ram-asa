package noseryoung.ch.carshopbackend.car;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }
    @GetMapping
    public List<Car> list(@RequestParam(required = false) String q) {
        return service.list(q);
    }
    @GetMapping("/{id}")
    public Car get(@PathVariable Long id) {
        return service.get(id);
    }
    @PostMapping
    public ResponseEntity<Car> create(@Valid @RequestBody CarDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }
    @PutMapping("/{id}")
    public Car update(@PathVariable Long id, @Valid @RequestBody CarDto dto) {
        return service.update(id, dto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}