package be.diher81.switchfully.api;

import java.util.UUID;

public class CustomerDto {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private AddressDto addressDto;

    public CustomerDto() {
    }

    public CustomerDto(UUID id, String firstName, String lastName, String email, String phoneNumber, AddressDto addressDto) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.addressDto = addressDto;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }
}
