package kokwabeerframework.msscbrewery.web.controller;

import kokwabeerframework.msscbrewery.services.ItemService;
import kokwabeerframework.msscbrewery.web.model.ItemDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<ItemDto> handlePost(@RequestBody ItemDto itemDto){
        ItemDto saveDto = itemService.saveNewItem(itemDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("location", "api/v1/item" + saveDto.getId().toString());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @PutMapping({"/{itemId}"})
    public ResponseEntity<ItemDto> updateItem(@PathVariable("itemId") UUID itemId, @RequestBody ItemDto itemDto){
    itemService.updateItem(itemId, itemDto);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping({"/{itemId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable("itemId") UUID itemId){
        itemService.deleteItem(itemId);
    }

}
