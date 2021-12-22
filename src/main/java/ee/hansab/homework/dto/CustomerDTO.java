package ee.hansab.homework.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDTO {
    private Long id;
    private String name;
    private List<CarDTO> cars;
}
