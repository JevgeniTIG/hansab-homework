package ee.hansab.homework.facade;

import ee.hansab.homework.dto.CarDTO;
import ee.hansab.homework.dto.CustomerDTO;
import ee.hansab.homework.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerFacade {

    private CarFacade carFacade;

    public CustomerFacade(@Autowired CarFacade carFacade) {
        this.carFacade = carFacade;
    }

    public CustomerDTO customerToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        List<CarDTO> listOfCars = new ArrayList<>();
        customer.getCars().forEach(dbCar -> {
            listOfCars.add(carFacade.carToCarDTO(dbCar));
        });
        customerDTO.setCars(listOfCars);
        return customerDTO;
    }
}

