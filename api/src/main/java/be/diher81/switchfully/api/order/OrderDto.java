package be.diher81.switchfully.api.order;

import be.diher81.switchfully.api.customer.CustomerDto;

import java.util.List;
import java.util.UUID;

public class OrderDto {

    private UUID id;
    private CustomerDto customerDto;
    private List<ItemGroupDto> itemGroupDtos;

    public OrderDto(UUID id, CustomerDto customerDto, List<ItemGroupDto> itemGroupDtos) {
        this.id = id;
        this.customerDto = customerDto;
        this.itemGroupDtos = itemGroupDtos;
    }

    public UUID getId() {
        return id;
    }

    public CustomerDto getCustomerDto() {
        return customerDto;
    }

    public List<ItemGroupDto> getItemGroupDtos() {
        return itemGroupDtos;
    }
}
