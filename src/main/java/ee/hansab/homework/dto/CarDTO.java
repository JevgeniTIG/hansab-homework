package ee.hansab.homework.dto;

import lombok.Data;

@Data
public class CarDTO {
    private Long id;
    private String make;
    private String model;
    private String numberplate;
}
