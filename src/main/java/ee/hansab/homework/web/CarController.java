package ee.hansab.homework.web;

import ee.hansab.homework.dto.CarDTO;
import ee.hansab.homework.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/cars")
public class CarController {

    private CarService carService;

    public CarController(@Autowired CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public ResponseEntity<List<CarDTO>> getAllCars() {
        List<CarDTO> listOfCars = carService.getAllCars();
        return new ResponseEntity<>(listOfCars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable(value = "id") String id) {
        CarDTO car = carService.getCarById(Long.valueOf(id));
        return new ResponseEntity<>(car, HttpStatus.OK);
    }


}
