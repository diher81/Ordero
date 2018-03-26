package be.diher81.switchfully.api.item;

import be.diher81.switchfully.domain.item.Item;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ItemMapper {

    @Inject
    public ItemMapper() {
    }

    public ItemDto toDto(Item item) {
        return new ItemDto(
                item.getItemId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getAmount()
        );
    }

    public Item toDomain(ItemDto itemDto) {
        if (itemDto.getId() != null) {
            return new Item(
                    itemDto.getId(),
                    itemDto.getName(),
                    itemDto.getDescription(),
                    itemDto.getPrice(),
                    itemDto.getAmount()
            );
        } else {
            return new Item(
                    itemDto.getName(),
                    itemDto.getDescription(),
                    itemDto.getPrice(),
                    itemDto.getAmount()
            );
        }
    }
}
