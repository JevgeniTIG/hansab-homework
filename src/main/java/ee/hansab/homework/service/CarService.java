package ee.hansab.homework.service;

import ee.hansab.homework.dto.CarDTO;
import ee.hansab.homework.entity.Car;
import ee.hansab.homework.facade.CarFacade;
import ee.hansab.homework.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;
    private CarFacade carFacade;

    public CarService(@Autowired CarRepository carRepository,
                      @Autowired CarFacade carFacade) {
        this.carRepository = carRepository;
        this.carFacade = carFacade;
    }


    public List<CarDTO> getAllCars() {
        List<Car> availableCars = new ArrayList<>();
        availableCars = carRepository.findAll();
        List<CarDTO> listOfCars = new ArrayList<>();
        availableCars.forEach(dbCar -> {
            listOfCars.add(carFacade.carToCarDTO(dbCar));
        });
        return listOfCars;
    }


    public CarDTO getCarById(Long id) {
        CarDTO carDTO = new CarDTO();
        Car dbCar = new Car();
        dbCar = carRepository.findCarById(id);
        if (dbCar == null) {
            return null;
        }
        carDTO = carFacade.carToCarDTO(dbCar);
        return carDTO;
    }
}

