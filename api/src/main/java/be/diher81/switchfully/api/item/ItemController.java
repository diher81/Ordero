package be.diher81.switchfully.api.item;

import be.diher81.switchfully.api.customer.CustomerDto;
import be.diher81.switchfully.domain.customer.Customer;
import be.diher81.switchfully.domain.item.Item;
import be.diher81.switchfully.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(path = "/items")
@RestController
public class ItemController {

    private ItemService itemService;
    private ItemMapper itemMapper;

    @Inject
    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<ItemDto> getItems() {
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : itemService.getAllItems()) {
            itemDtos.add(itemMapper.toDto(item));
        }
        return itemDtos;
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDto addNewItem(@RequestBody ItemDto itemDto) {
        return itemMapper.toDto(itemService.addItem(itemMapper.toDomain(itemDto)));
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ItemDto updateItem(@RequestBody ItemDto itemDto) {
        return itemMapper.toDto(itemService.updateItem(itemMapper.toDomain(itemDto)));
    }
}
