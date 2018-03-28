package be.diher81.switchfully.service;

import be.diher81.switchfully.domain.customer.CustomerInstantiationException;
import be.diher81.switchfully.domain.item.Item;
import be.diher81.switchfully.domain.item.ItemRepository;
import be.diher81.switchfully.domain.item.ItemGroup;
import be.diher81.switchfully.domain.order.Order;
import be.diher81.switchfully.domain.order.OrderInstantiationException;
import be.diher81.switchfully.domain.order.OrderRepository;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

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
        assertMandatoryFieldsFilledIn(order);
        calculateShippingDates(order);
        orderRepository.addOrder(order);
        return calculateOrderPrice(order);
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

    private BigDecimal calculateOrderPrice(Order order) {
        BigDecimal itemGroupPrice;
        BigDecimal orderPrice = BigDecimal.ZERO;
        for (ItemGroup itemGroup : order.getItemGroups()) {
            Item item = itemRepository.getItem(itemGroup.getItemId());
            itemGroupPrice = item.getPrice().multiply(BigDecimal.valueOf(itemGroup.getAmount()));
            itemGroup.setItemGroupPrice(itemGroupPrice);
            orderPrice = orderPrice.add(itemGroupPrice);
        }
        order.setOrderPrice(orderPrice);
        if (Order.getAllOrdersTotalPrice() == null) {
            Order.setAllOrdersTotalPrice(BigDecimal.ZERO);
        }
        Order.setAllOrdersTotalPrice(Order.getAllOrdersTotalPrice().add(orderPrice));
        return orderPrice;
    }

    public List<Order> getOrders() {
        return orderRepository.getOrders();
    }

    private void assertMandatoryFieldsFilledIn(Order order) {
        if (order.getCustomer().getFirstName() == null) {
            throw new CustomerInstantiationException("Please provide a first name.");
        }
        if (order.getCustomer().getLastName() == null) {
            throw new CustomerInstantiationException("Please provide a last name.");
        }
        if (order.getCustomer().getEmail() == null) {
            throw new CustomerInstantiationException("Please provide an e-mail address.");
        }
        if (order.getCustomer().getPhoneNumber() == null) {
            throw new CustomerInstantiationException("Please provide a phone number.");
        }
        if (order.getCustomer().getAddress() == null) {
            throw new CustomerInstantiationException("Please provide an address.");
        }
        if (order.getCustomer().getAddress().getStreet() == null) {
            throw new CustomerInstantiationException("Please provide a street.");
        }
        if (order.getCustomer().getAddress().getHouseNumber() == null) {
            throw new CustomerInstantiationException("Please provide a house number.");
        }
        if (order.getCustomer().getAddress().getPostalCode() == null) {
            throw new CustomerInstantiationException("Please provide a postal code.");
        }
        if (order.getCustomer().getAddress().getCity() == null) {
            throw new CustomerInstantiationException("Please provide city.");
        }
        for (ItemGroup itemGroup : order.getItemGroups()) {
            if (itemGroup.getItemId() == null) {
                throw new CustomerInstantiationException("Please provide an item id.");
            }
            if (itemGroup.getAmount() <= 0) {
                throw new CustomerInstantiationException("Amount must be positive.");
            }
        }
    }

    private void assertOrderIdBelongsToCustomer(String customerId, String orderId) {
        boolean combinationOk = false;
        for (Order orderFromRepo : orderRepository.getOrders()) {
            if (orderFromRepo.getId().equals(UUID.fromString(orderId))){
                if (orderFromRepo.getCustomer().getCustomerId().equals(customerId)) {
                    combinationOk = true;
                }
            }
        }
        if (! combinationOk) {
            throw new OrderInstantiationException(
                    String.format("This orderId (%s) does not belong to customer with id %s",
                            orderId, customerId));
        }
    }

    public BigDecimal addReOrder(String customerId, String orderId) {
        assertOrderIdBelongsToCustomer(customerId, orderId);
        return calculateOrderPrice(orderRepository.getOrder(UUID.fromString(orderId)));
    }
}
