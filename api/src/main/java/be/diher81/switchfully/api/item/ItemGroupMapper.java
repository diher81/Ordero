package be.diher81.switchfully.api.item;

import be.diher81.switchfully.domain.order.ItemGroup;

import javax.inject.Named;

@Named
public class ItemGroupMapper {

    public ItemGroupDto toDto(ItemGroup itemGroup) {
        return new ItemGroupDto(
                itemGroup.getId(),
                itemGroup.getItemId(),
                itemGroup.getAmount(),
                itemGroup.getShippingDate()
        );
    }

    public ItemGroup toDomain(ItemGroupDto itemGroupDto) {
        return new ItemGroup(
                itemGroupDto.getId(),
                itemGroupDto.getItemId(),
                itemGroupDto.getAmount(),
                itemGroupDto.getShippingDate()
        );
    }
}
