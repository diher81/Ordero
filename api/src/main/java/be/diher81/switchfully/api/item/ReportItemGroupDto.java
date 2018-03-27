package be.diher81.switchfully.api.item;

import java.math.BigDecimal;

public class ReportItemGroupDto {

    private String itemName;
    private long amount;
    private BigDecimal itemGroupPrice;

    public ReportItemGroupDto() {
    }

    public ReportItemGroupDto(String itemName, long amount, BigDecimal itemGroupPrice) {
        this.itemName = itemName;
        this.amount = amount;
        this.itemGroupPrice = itemGroupPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public long getAmount() {
        return amount;
    }

    public BigDecimal getItemGroupPrice() {
        return itemGroupPrice;
    }
}
