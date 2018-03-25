package be.diher81.switchfully.domain;

import java.util.UUID;

public class Customer {

    private UUID customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Address address;

    public Customer(String firstName, String lastName, String email, String phoneNumber, Address address) {
        this.customerId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public UUID getCustomerId() {
        return customerId;
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
