package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.Address;

import javax.inject.Named;

@Named
public class AddressMapper {

    public AddressDto toDto(Address address) {
        return new AddressDto(
                address.getStreet(),
                address.getHouseNumber(),
                address.getPostalCode(),
                address.getCity()
        );
    }
}
