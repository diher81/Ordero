package be.diher81.switchfully.api.item;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemDto {

    private UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private long amount;

    public ItemDto() {
    }

    public ItemDto(UUID id, String name, String description, BigDecimal price, long amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
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


}
