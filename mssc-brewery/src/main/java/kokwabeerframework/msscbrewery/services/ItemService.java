package kokwabeerframework.msscbrewery.services;

import kokwabeerframework.msscbrewery.web.model.ItemDto;

import java.util.UUID;

public interface ItemService {
    ItemDto getItemById(UUID itemId);
}
