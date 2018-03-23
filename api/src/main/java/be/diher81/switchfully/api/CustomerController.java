package be.diher81.switchfully.api;

import be.diher81.switchfully.service.CustomerService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerController {

    private CustomerService customerService;

    @Inject
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

}
