package be.diher81.switchfully.api.order;

import be.diher81.switchfully.api.customer.CustomerMapper;
import be.diher81.switchfully.api.item.ReportItemGroupDto;
import be.diher81.switchfully.api.item.ReportItemGroupMapper;
import be.diher81.switchfully.domain.order.ItemGroup;
import be.diher81.switchfully.domain.order.Order;

import javax.inject.Inject;
import java.util.ArrayList;

public class ReportOrderMapper {

    private CustomerMapper customerMapper;
    private ReportItemGroupMapper reportItemGroupMapper;

    @Inject
    public ReportOrderMapper(CustomerMapper customerMapper, ReportItemGroupMapper itemGroupMapper) {
        this.customerMapper = customerMapper;
        this.reportItemGroupMapper = reportItemGroupMapper;
    }

    public ReportOrderDto toDto(Order order) {
        return new ReportOrderDto(
                order.getId(),
                customerMapper.toDto(order.getCustomer()),
                mapReportItemGroupsToDtos(order)
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
