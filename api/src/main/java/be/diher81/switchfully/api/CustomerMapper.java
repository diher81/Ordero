package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.Customer;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerMapper {

    AddressMapper addressMapper;

    @Inject
    public CustomerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                addressMapper.toDto(customer.getAddress())
        );
    }
}