package kokwabeerframework.msscbrewery.services;

import kokwabeerframework.msscbrewery.web.model.TableDto;

import java.util.UUID;

public interface TableService {
    TableDto getTableById(UUID tableId);

    TableDto saveNewTable(TableDto tableDto);

    void updateTable(UUID tableId, TableDto tableDto);

    void deleteTable(UUID tableId);
}
