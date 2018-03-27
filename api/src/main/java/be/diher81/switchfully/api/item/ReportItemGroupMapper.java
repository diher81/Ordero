package be.diher81.switchfully.api.item;

import be.diher81.switchfully.api.item.ReportItemGroupDto;
import be.diher81.switchfully.domain.order.ItemGroup;
import be.diher81.switchfully.service.ItemService;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class ReportItemGroupMapper {

    private ItemService itemService;

    @Inject
    public ReportItemGroupMapper(ItemService itemService) {
        this.itemService = itemService;
    }

    public ReportItemGroupDto toDto(ItemGroup itemGroup) {
        return new ReportItemGroupDto(
                itemService.getItem(itemGroup.getItemId()).getName(),
                itemGroup.getAmount(),
                itemGroup.getItemGroupPrice()
        );
    }
}
