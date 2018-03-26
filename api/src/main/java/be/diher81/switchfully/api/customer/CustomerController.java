package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.customer.Customer;
import be.diher81.switchfully.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "/customers")
@RestController
public class CustomerController {

    private CustomerService customerService;
    private CustomerMapper customerMapper;

    @Inject
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getCustomers() {
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customerService.getCustomers()) {
            customerDtos.add(customerMapper.toDto(customer));
        }
        return customerDtos;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto addNewCustomer(@RequestBody CustomerDto customerDto) {
        return customerMapper.toDto(customerService.addNewCustomer(customerMapper.toDomain(customerDto)));
    }
}
