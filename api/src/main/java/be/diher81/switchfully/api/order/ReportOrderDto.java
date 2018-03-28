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

    public ReportOrderDto() {
    }

    public ReportOrderDto(UUID id, List<ReportItemGroupDto> reportItemGroupDtos) {
        this.id = id;
        this.reportItemGroupDtos = reportItemGroupDtos;
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
}
