package be.diher81.switchfully.api.order;

import be.diher81.switchfully.domain.order.Order;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class OrderMapper {

    @Inject
    public OrderMapper() {
    }

    public OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getCustomer(),
                order.getItemGroups()
        );
    }

    public Order toDomain(OrderDto orderDto) {
        return new Order(
                orderDto.getCustomer(),
                orderDto.getItemGroups()
        );
    }
}
