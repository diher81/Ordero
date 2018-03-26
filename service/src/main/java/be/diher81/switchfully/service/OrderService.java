package be.diher81.switchfully.service;

import be.diher81.switchfully.domain.item.Item;
import be.diher81.switchfully.domain.item.ItemRepository;
import be.diher81.switchfully.domain.order.ItemGroup;
import be.diher81.switchfully.domain.order.Order;
import be.diher81.switchfully.domain.order.OrderRepository;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;

@Named
public class OrderService {

    private OrderRepository orderRepository;
    private ItemRepository itemRepository;

    @Inject
    public OrderService(OrderRepository orderRepository, ItemRepository itemRepository) {
        this.orderRepository = orderRepository;
        this.itemRepository = itemRepository;
    }

    public BigDecimal addOrder(Order order) {
        calculateShippingDates(order);
        orderRepository.addOrder(order);
        return calculateOrderPrice(order.getItemGroups());
    }

    private void calculateShippingDates(Order order) {
        for (ItemGroup itemGroup : order.getItemGroups()) {
            Item item = itemRepository.getItem(itemGroup.getItemId());
            if (item.getAmount() >= itemGroup.getAmount()) {
                itemGroup.setShippingDate(DateTime.now().plusDays(1));
            } else {
                itemGroup.setShippingDate(DateTime.now().plusDays(7));
            }
        }
    }

    private BigDecimal calculateOrderPrice(List<ItemGroup> itemGroups) {
        BigDecimal price = BigDecimal.ZERO;
        for (ItemGroup itemGroup : itemGroups) {
            Item item = itemRepository.getItem(itemGroup.getItemId());
            price = price.add(item.getPrice().multiply(BigDecimal.valueOf(itemGroup.getAmount())));
        }
        return price;
    }

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }
}
