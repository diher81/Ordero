package be.diher81.switchfully.api;

import be.diher81.switchfully.domain.Address;

public class CustomerDto {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address address;

    public CustomerDto(String firstName, String lastName, String email, String phoneNumber, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public Address getAddress() {
        return address;
    }
}
