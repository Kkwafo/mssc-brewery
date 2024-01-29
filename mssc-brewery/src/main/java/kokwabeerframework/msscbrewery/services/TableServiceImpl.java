package kokwabeerframework.msscbrewery.services;

import kokwabeerframework.msscbrewery.web.model.TableDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TableServiceImpl implements TableService{

    @Override
    public TableDto getTableById(UUID tableId) {
        return TableDto.builder().id(UUID.randomUUID())
                .orderNumber(0001)
                .total(453.32)
                .build();

    }

    @Override
    public TableDto saveNewTable(TableDto tableDto) {
        return null;
    }

    @Override
    public void updateTable(UUID tableId, TableDto tableDto) {

    }

    @Override
    public void deleteTable(UUID tableId) {

    }
}
