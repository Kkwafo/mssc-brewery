package kokwabeerframework.msscbrewery.web.controller;

import kokwabeerframework.msscbrewery.services.TableService;
import kokwabeerframework.msscbrewery.web.model.TableDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("api/v1/table")
@RestController
public class TableController {

    private final TableService tableService;

    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping({"/{tableId}"})
    public ResponseEntity<TableDto> getTable(@PathVariable("tableId") UUID tableId) {
        return new ResponseEntity<>(tableService.getTableById(tableId), HttpStatus.OK);
    }
}

