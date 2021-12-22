package ee.hansab.homework.web;

import ee.hansab.homework.dto.CarDTO;
import ee.hansab.homework.dto.CustomerDTO;
import ee.hansab.homework.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/users")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(@Autowired CustomerService customerService) {
        this.customerService = customerService;

    }

    @GetMapping("")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers() {
        List<CustomerDTO> listOfCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(listOfCustomers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(value = "id") String id) {
        CustomerDTO customer = customerService.getCustomerById(Long.valueOf(id));
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @GetMapping("/{id}/cars")
    public ResponseEntity<List<CarDTO>> getCustomerCars(@PathVariable(value = "id") String id) {
        CustomerDTO customer = customerService.getCustomerById(Long.valueOf(id));
        List<CarDTO> listOfCars = customer.getCars();
        return new ResponseEntity<>(listOfCars, HttpStatus.OK);
    }


}
