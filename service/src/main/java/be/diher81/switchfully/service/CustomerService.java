package be.diher81.switchfully.service;

import be.diher81.switchfully.domain.customer.Customer;
import be.diher81.switchfully.domain.customer.CustomerInstantiationException;
import be.diher81.switchfully.domain.customer.CustomerRepository;

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

    public Customer addNewCustomer(Customer customer) {
            assertMandatoryFieldsFilledIn(customer);
            return customerRepository.addNewCustomer(customer);
    }

    private void assertMandatoryFieldsFilledIn(Customer customer) {
        if (customer.getFirstName() == null) {
            throw new CustomerInstantiationException("Please provide a first name.");
        }
        if (customer.getLastName() == null) {
            throw new CustomerInstantiationException("Please provide a last name.");
        }
        if (customer.getEmail() == null) {
            throw new CustomerInstantiationException("Please provide an e-mail address.");
        }
        if (customer.getPhoneNumber() == null) {
            throw new CustomerInstantiationException("Please provide a phone number.");
        }
        if (customer.getAddress() == null) {
            throw new CustomerInstantiationException("Please provide an address.");
        }
        if (customer.getAddress().getStreet() == null) {
            throw new CustomerInstantiationException("Please provide a street.");
        }
        if (customer.getAddress().getHouseNumber() == null) {
            throw new CustomerInstantiationException("Please provide a house number.");
        }
        if (customer.getAddress().getPostalCode() == null) {
            throw new CustomerInstantiationException("Please provide a postal code.");
        }
        if (customer.getAddress().getCity() == null) {
            throw new CustomerInstantiationException("Please provide city.");
        }
    }
}
