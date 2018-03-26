package be.diher81.switchfully.api.order;

import be.diher81.switchfully.api.customer.CustomerMapper;
import be.diher81.switchfully.domain.order.ItemGroup;
import be.diher81.switchfully.domain.order.Order;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;

@Named
public class OrderMapper {

    private CustomerMapper customerMapper;
    private ItemGroupMapper itemGroupMapper;

    @Inject
    public OrderMapper(CustomerMapper customerMapper, ItemGroupMapper itemGroupMapper) {
        this.customerMapper = customerMapper;
        this.itemGroupMapper = itemGroupMapper;
    }

    public OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                customerMapper.toDto(order.getCustomer()),
                mapItemGroupsToDtos(order)
        );
    }

    private ArrayList<ItemGroupDto> mapItemGroupsToDtos(Order order) {
        ArrayList<ItemGroupDto> itemGroupDtos = new ArrayList<>();
        for (ItemGroup itemGroup : order.getItemGroups()) {
            itemGroupDtos.add(itemGroupMapper.toDto(itemGroup));
        }
        return itemGroupDtos;
    }

    public Order toDomain(OrderDto orderDto) {
        return new Order(
                customerMapper.toDomain(orderDto.getCustomerDto()),
                mapItemGroupDtosToItemGroups(orderDto)
        );
    }

    private ArrayList<ItemGroup> mapItemGroupDtosToItemGroups(OrderDto orderDto) {
        ArrayList<ItemGroup> itemGroups = new ArrayList<>();
        for (ItemGroupDto itemGroupDto : orderDto.getItemGroupDtos()) {
            itemGroups.add(itemGroupMapper.toDomain(itemGroupDto));
        }
        return itemGroups;
    }
}
