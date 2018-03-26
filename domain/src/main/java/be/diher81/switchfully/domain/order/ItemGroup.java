package be.diher81.switchfully.domain.order;

import java.util.UUID;
import org.joda.time.DateTime;

public class ItemGroup {

    private UUID id;
    private UUID itemId;
    private long amount;
    private DateTime shippingDate;

    public ItemGroup(UUID itemId, long amount, DateTime shippingDate) {
        this.id = UUID.randomUUID();
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public ItemGroup(UUID id, UUID itemId, long amount, DateTime shippingDate) {
        this.id = id;
        this.itemId = itemId;
        this.amount = amount;
        this.shippingDate = shippingDate;
    }

    public UUID getId() {
        return id;
    }

    public UUID getItemId() {
        return itemId;
    }

    public long getAmount() {
        return amount;
    }

    public DateTime getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(DateTime shippingDate) {
        this.shippingDate = shippingDate;
    }
}
