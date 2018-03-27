package be.diher81.switchfully.domain.item;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Named
public class ItemRepository {

    private List<Item> items;

    @Inject
    public ItemRepository() {
        this.items = new ArrayList<>();
        createInitialStock();
    }

    private void createInitialStock() {
        items.add(new Item("Blade 1", "Tibhar Nimbus OFF-", BigDecimal.valueOf(45.50), 20));
        items.add(new Item("Blade 2", "Butterfly Zhank Jike Super ZLC", BigDecimal.valueOf(95.50), 2));
        items.add(new Item("Blade 3", "MC1", BigDecimal.valueOf(53), 2000));
        items.add(new Item("Rubber 1", "Xiom Vega", BigDecimal.valueOf(35.50), 20500));
        items.add(new Item("Rubber 2", "Tibhar Nimbus Soft", BigDecimal.valueOf(41.00), 1));
        items.add(new Item("Rubber 3", "Tibhar Aurus", BigDecimal.valueOf(55.50), 10));
        items.add(new Item("Ball 1", "Stiga Celluloid", BigDecimal.valueOf(0.50), 200000000L));
        items.add(new Item("Ball 2", "Joola 40+ plastic", BigDecimal.valueOf(1.50), 200000000000L));
    }

    // only used to create initial order repo
    public Item getRandomItem() {
        int index = 0;
        int i = (int) (Math.random() * getItems().size())   ;
        for (Item item : getItems()) {
            if (index == i) {
                return item;
            }
            index++;
        }
        return null;
    }

    public Item addItem(Item item) {
        items.add(item);
        return item;
    }

    public List<Item> getItems() {
        return items;
    }

    public Item updateItem(Item item) {
        Item itemToUpdate = getItem(item.getItemId());
        itemToUpdate.setName(item.getName());
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate.setAmount(itemToUpdate.getAmount());
        return itemToUpdate;
    }

    public Item getItem(UUID itemId) {
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }
}
