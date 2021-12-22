package ee.hansab.homework.facade;

import ee.hansab.homework.dto.CarDTO;
import ee.hansab.homework.entity.Car;
import org.springframework.stereotype.Component;


@Component
public class CarFacade {
    public CarDTO carToCarDTO(Car car) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(car.getId());
        carDTO.setMake(car.getMake());
        carDTO.setModel(car.getModel());
        carDTO.setNumberplate(car.getNumberplate());

        return carDTO;
    }
}