package be.diher81.switchfully.api.order;

import be.diher81.switchfully.api.customer.CustomerDto;
import be.diher81.switchfully.api.item.ItemGroupDto;
import be.diher81.switchfully.api.item.ReportItemGroupDto;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ReportOrderDto {

    private UUID id;
    private List<ReportItemGroupDto> reportItemGroupDtos;
    private BigDecimal orderPrice;
    private BigDecimal allOrdersTotalPrice;

    public ReportOrderDto() {
    }

    public ReportOrderDto(UUID id, List<ReportItemGroupDto> reportItemGroupDtos, BigDecimal orderPrice, BigDecimal allOrdersTotalPrice) {
        this.id = id;
        this.reportItemGroupDtos = reportItemGroupDtos;
        this.orderPrice = orderPrice;
        this.allOrdersTotalPrice = allOrdersTotalPrice;
    }

    public UUID getId() {
        return id;
    }

    public List<ReportItemGroupDto> getReportItemGroupDtos() {
        return reportItemGroupDtos;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public BigDecimal getAllOrdersTotalPrice() {
        return allOrdersTotalPrice;
    }
}
