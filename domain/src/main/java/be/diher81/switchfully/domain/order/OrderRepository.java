package be.diher81.switchfully.domain.order;

import be.diher81.switchfully.domain.customer.Address;
import be.diher81.switchfully.domain.customer.Customer;
import be.diher81.switchfully.domain.item.Item;
import be.diher81.switchfully.domain.item.ItemRepository;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Named
public class OrderRepository {

    private List<Order> orders;
    private ItemRepository itemRepository;

    @Inject
    public OrderRepository(ItemRepository itemRepository) {
        this.orders = new ArrayList<>();
        this.itemRepository = itemRepository;
        createInitialOrders();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    private void createInitialOrders() {
        ItemGroup itemGroup1 = new ItemGroup(itemRepository.getRandomItem().getItemId(), 3L, DateTime.now());
        ItemGroup itemGroup2 = new ItemGroup(itemRepository.getRandomItem().getItemId(), 4L, DateTime.now().plusDays(1));
        ArrayList<ItemGroup> itemGroups = new ArrayList<>();
        itemGroups.add(itemGroup1);
//        itemGroups.add(itemGroup2);
        Customer customer = new Customer("Stijn", "Verschueren", "s.v@cm.be", "0497979797",
                new Address("Assurstreet", "10", "2020", "Schaerbeek"));
        orders.add(new Order(customer,itemGroups));
    }
}
