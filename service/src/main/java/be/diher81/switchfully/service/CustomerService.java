package be.diher81.switchfully.service;

import be.diher81.switchfully.domain.Customer;
import be.diher81.switchfully.domain.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerService {

    private CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addNewCustomer(Customer customer) {
        customerRepository.addNewCustomerToRepository(customer);
    }
}
