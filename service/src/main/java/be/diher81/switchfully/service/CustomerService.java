package be.diher81.switchfully.service;

import be.diher81.switchfully.domain.Customer;
import be.diher81.switchfully.domain.CustomerRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CustomerService {

    private CustomerRepository customerRepository;

    @Inject
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.getCustomers();
    }

    public void addNewCustomer(Customer customer) {
        customerRepository.addNewCustomer(customer);
    }
}
