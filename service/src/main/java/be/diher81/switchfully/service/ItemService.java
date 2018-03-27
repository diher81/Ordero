package be.diher81.switchfully.service;

import be.diher81.switchfully.domain.customer.CustomerInstantiationException;
import be.diher81.switchfully.domain.item.Item;
import be.diher81.switchfully.domain.item.ItemInstantiationException;
import be.diher81.switchfully.domain.item.ItemRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Named
public class ItemService {

    private ItemRepository itemRepository;

    @Inject
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItems() {
        return itemRepository.getItems();
    }

    public Item getItem(UUID id) {
        return itemRepository.getItem(id);
    }

    public Item addItem(Item item) {
        assertMandatoryFieldsFilledIn(item);
        return itemRepository.addItem(item);
    }

    public Item updateItem(Item item) {
        if (getItem(item.getItemId()) == null) {
            throw new CustomerInstantiationException("Item does not exist. Provide an existing ID");
        }
        assertMandatoryFieldsFilledIn(item);
        return itemRepository.updateItem(item);
    }

    private void assertMandatoryFieldsFilledIn(Item item) {
        if (item.getName() == null) {
            throw new ItemInstantiationException("Item name is mandatory.");
        }
        if (item.getDescription() == null) {
            throw new ItemInstantiationException("Item description is mandatory.");
        }
        if (item.getPrice() == null) {
            throw new ItemInstantiationException("Item price is mandatory.");
        }
        if (item.getPrice().compareTo(BigDecimal.ZERO) < 1) {
            throw new ItemInstantiationException("Item price should be positive.");
        }
        if (item.getAmount() <= 0) {
            throw new ItemInstantiationException("Initial item amount has to be positive.");
        }
    }
}
