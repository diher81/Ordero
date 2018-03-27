package be.diher81.switchfully.api.customer;

import be.diher81.switchfully.domain.customer.Customer;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CustomerMapper {

    private AddressMapper addressMapper;

    @Inject
    public CustomerMapper(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public CustomerDto toDto(Customer customer) {
        return new CustomerDto(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhoneNumber(),
                addressMapper.toDto(customer.getAddress())
        );
    }

    public Customer toDomain(CustomerDto customerDto) {
        return new Customer(customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getPhoneNumber(),
                addressMapper.toDomain(customerDto.getAddressDto())
        );
    }
}
