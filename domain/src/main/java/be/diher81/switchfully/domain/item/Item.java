package be.diher81.switchfully.domain.item;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public class Item {

    private UUID itemId;
    private String name;
    private String description;
    private BigDecimal price;
    private long amount;

    public Item(String name, String description, BigDecimal price, long amount) {
        this.itemId = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Item(UUID id, String name, String description, BigDecimal price, long amount) {
        this.itemId = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public long getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(itemId);
    }
}
