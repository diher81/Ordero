package be.diher81.switchfully.api.order;

import be.diher81.switchfully.domain.customer.Customer;
import be.diher81.switchfully.domain.order.ItemGroup;

import java.util.List;
import java.util.UUID;

public class OrderDto {

    private UUID id;
    private Customer customer;
    private List<ItemGroup> itemGroups;

    public OrderDto(UUID id, Customer customer, List<ItemGroup> itemGroups) {
        this.id = id;
        this.customer = customer;
        this.itemGroups = itemGroups;
    }

    public UUID getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }
}
