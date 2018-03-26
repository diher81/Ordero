package be.diher81.switchfully.service;

import be.diher81.switchfully.domain.item.Item;
import be.diher81.switchfully.domain.item.ItemInstantiationException;
import be.diher81.switchfully.domain.item.ItemRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class ItemService {

    ItemRepository itemRepository;

    @Inject
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item addItem(Item item) {
        assertMandatoryFieldsFilledIn(item);
        return itemRepository.addItem(item);
    }

    private void assertMandatoryFieldsFilledIn(Item item) {
        if (item.getName() == null) {
            throw new ItemInstantiationException("Item name is mandatory.");
        }
        if (item.getDescription() == null) {
            throw new ItemInstantiationException("Item description is mandatory.");
        }
        if (item.getPrice().compareTo(BigDecimal.ZERO) != 1) {
            throw new ItemInstantiationException("Item price should be positive.");
        }
        if (item.getAmount() <= 0) {
            throw new ItemInstantiationException("Initial item amount has to be positive.");
        }
    }
}
