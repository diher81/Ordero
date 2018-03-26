package be.diher81.switchfully.domain.order;

import be.diher81.switchfully.domain.customer.Address;
import be.diher81.switchfully.domain.customer.Customer;
import be.diher81.switchfully.domain.item.Item;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
public class OrderRepository {

    private List<Order> orders;

    @Inject
    public OrderRepository() {
        this.orders = new ArrayList<>();
        createInitialOrders();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    private void createInitialOrders() {
        Item item1 = new Item("Blade 1", "Tibhar Nimbus OFF-", BigDecimal.valueOf(45.50), 20);
        Item item2 = new Item("Blade 2", "Tibhar Nimbus OFF+", BigDecimal.valueOf(45.51), 20);
        ItemGroup itemGroup1 = new ItemGroup(item1.getItemId(), 3L, DateTime.now());
        ItemGroup itemGroup2 = new ItemGroup(item2.getItemId(), 4L, DateTime.now().plusDays(1));
        ArrayList<ItemGroup> itemGroups = new ArrayList<>();
        itemGroups.add(itemGroup1);
        itemGroups.add(itemGroup2);
        Customer customer = new Customer("Stijn", "Verschueren", "s.v@cm.be", "0497979797",
                new Address("Assurstreet", "10", "2020", "Schaerbeek"));
        orders.add(new Order(customer,itemGroups));
    }
}
