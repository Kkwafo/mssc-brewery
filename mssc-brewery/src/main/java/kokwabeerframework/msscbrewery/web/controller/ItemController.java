package kokwabeerframework.msscbrewery.web.controller;

import kokwabeerframework.msscbrewery.services.ItemService;
import kokwabeerframework.msscbrewery.web.model.ItemDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("api/v1/item")
@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping({"/{itemId}"})
    public ResponseEntity<ItemDto>getItem(@PathVariable("itemId") UUID itemId){
        return new ResponseEntity<>(itemService.getItemById(itemId), HttpStatus.OK);
    }

}
