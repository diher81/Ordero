package be.diher81.switchfully.domain.order;

import be.diher81.switchfully.domain.customer.Customer;
import be.diher81.switchfully.domain.customer.CustomerRepository;
import be.diher81.switchfully.domain.item.ItemGroup;
import be.diher81.switchfully.domain.item.ItemRepository;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Named
public class OrderRepository {

    private List<Order> orders;
    private ItemRepository itemRepository;
    private CustomerRepository customerRepository;

    @Inject
    public OrderRepository(ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.orders = new ArrayList<>();
        this.itemRepository = itemRepository;
        this.customerRepository = customerRepository;
        createInitialOrders();
    }

    public List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public Order getOrder(UUID orderId) {
        for (Order order : getOrders()) {
            if (order.getId().equals(orderId)) {
                return order;
            }
        }
        return null;
    }

    private void createInitialOrders() {
        ItemGroup itemGroup1 = new ItemGroup(itemRepository.getRandomItem().getItemId(), 3L, DateTime.now());
        ItemGroup itemGroup2 = new ItemGroup(itemRepository.getRandomItem().getItemId(), 4L, DateTime.now().plusDays(1));
        Customer customer1 = customerRepository.getRandomCustomer();
        ArrayList<ItemGroup> itemGroups = new ArrayList<>();
        itemGroups.add(itemGroup1);
        itemGroups.add(itemGroup2);
        orders.add(new Order(customer1,itemGroups));
    }

}
