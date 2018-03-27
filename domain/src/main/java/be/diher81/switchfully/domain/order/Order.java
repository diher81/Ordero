package be.diher81.switchfully.domain.order;

import be.diher81.switchfully.domain.customer.Customer;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {

    private UUID id;
    private Customer customer;
    private List<ItemGroup> itemGroups;
    private BigDecimal orderPrice;
    private static BigDecimal allOrdersTotalPrice;

    public Order(Customer customer, List<ItemGroup> itemGroups) {
        this.id = UUID.randomUUID();
        this.customer = customer;
        this.itemGroups = itemGroups;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<ItemGroup> getItemGroups() {
        return Collections.unmodifiableList(itemGroups);
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public static BigDecimal getAllOrdersTotalPrice() {
        return allOrdersTotalPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public static void setAllOrdersTotalPrice(BigDecimal allOrdersTotalPrice) {
        Order.allOrdersTotalPrice = allOrdersTotalPrice;
    }
}
