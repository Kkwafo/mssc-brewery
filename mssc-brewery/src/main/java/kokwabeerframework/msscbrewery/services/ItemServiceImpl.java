package kokwabeerframework.msscbrewery.services;

import kokwabeerframework.msscbrewery.web.model.ItemDto;
import kokwabeerframework.msscbrewery.web.model.TableDto;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ItemServiceImpl implements  ItemService{

    @Override
    public ItemDto getItemById(UUID itemId) {
        return ItemDto.builder().id(UUID.randomUUID())
                .name("Beer")
                .quantity(2)
                .build();
    }
}
