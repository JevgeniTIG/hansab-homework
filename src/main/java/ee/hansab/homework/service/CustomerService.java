package ee.hansab.homework.service;

import ee.hansab.homework.dto.CustomerDTO;
import ee.hansab.homework.entity.Customer;
import ee.hansab.homework.facade.CustomerFacade;
import ee.hansab.homework.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;
    private CustomerFacade customerFacade;

    public CustomerService(@Autowired CustomerRepository customerRepository,
                           @Autowired CustomerFacade customerFacade) {
        this.customerRepository = customerRepository;
        this.customerFacade = customerFacade;
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> availableCustomers = new ArrayList<>();
        availableCustomers = customerRepository.findAll();
        List<CustomerDTO> listOfCustomers = new ArrayList<>();
        availableCustomers.forEach(dbCustomer -> {
            listOfCustomers.add(customerFacade.customerToCustomerDTO(dbCustomer));
        });
        return listOfCustomers;
    }


    public CustomerDTO getCustomerById(Long id) {
        CustomerDTO customerDTO = new CustomerDTO();
        Customer dbCustomer = new Customer();
        dbCustomer = customerRepository.findCustomerById(id);
        if (dbCustomer == null) {
            return null;
        }
        customerDTO = customerFacade.customerToCustomerDTO(dbCustomer);
        return customerDTO;
    }

}
