package be.diher81.switchfully.domain.order;

import be.diher81.switchfully.domain.customer.Customer;

import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;
    private Customer customer;
    private List<ItemGroup> itemGroups;

    public Order(Customer customer, List<ItemGroup> itemGroups) {
        this.id = UUID.randomUUID();
        this.customer = customer;
        this.itemGroups = itemGroups;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public UUID getId() {
        return id;
    }

}
