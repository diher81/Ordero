package be.diher81.switchfully.api.order;

import be.diher81.switchfully.api.customer.CustomerMapper;
import be.diher81.switchfully.api.item.ReportItemGroupDto;
import be.diher81.switchfully.api.item.ReportItemGroupMapper;
import be.diher81.switchfully.domain.item.ItemGroup;
import be.diher81.switchfully.domain.order.Order;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;

@Named
public class ReportOrderMapper {

    private ReportItemGroupMapper reportItemGroupMapper;

    @Inject
    public ReportOrderMapper(ReportItemGroupMapper reportItemGroupMapper) {
        this.reportItemGroupMapper = reportItemGroupMapper;
    }

    public ReportOrderDto toDto(Order order) {
        return new ReportOrderDto(
                order.getId(),
                mapReportItemGroupsToDtos(order),
                order.getOrderPrice(),
                Order.getAllOrdersTotalPrice()
        );
    }

    private ArrayList<ReportItemGroupDto> mapReportItemGroupsToDtos(Order order) {
        ArrayList<ReportItemGroupDto> reportItemGroupDtos = new ArrayList<>();
        for (ItemGroup itemGroup : order.getItemGroups()) {
            reportItemGroupDtos.add(reportItemGroupMapper.toDto(itemGroup));
        }
        return reportItemGroupDtos;
    }

}
