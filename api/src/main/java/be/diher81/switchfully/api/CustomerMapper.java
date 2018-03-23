package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.Customer;

import javax.inject.Named;

@Named
public class CustomerMapper {

    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                customer.getAddress());
    }
}
