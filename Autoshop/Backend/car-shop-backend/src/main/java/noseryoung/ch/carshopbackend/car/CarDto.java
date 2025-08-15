package noseryoung.ch.carshopbackend.car;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CarDto(
        @NotBlank String make,
        @NotBlank String model,
        @Min(1950) @Max(2100) int year,
        @DecimalMin(value="0.0", inclusive=false) BigDecimal price,
        @Min(0) int stock,
        String imageUrl
) {}