package kokwabeerframework.msscbrewery.web.controller;

import kokwabeerframework.msscbrewery.services.TableService;
import kokwabeerframework.msscbrewery.web.model.TableDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public ResponseEntity<TableDto> handlePost(@RequestBody TableDto tableDto){
        TableDto saveDto = tableService.saveNewTable(tableDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "api/v1/table" + saveDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    @PutMapping({"/{tableId}"})
    public ResponseEntity<TableDto> updateTable(@PathVariable("tableId")UUID tableId, TableDto tableDto){
        tableService.updateTable(tableId, tableDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{tableId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTable(@PathVariable("tableId") UUID tableId){
        tableService.deleteTable(tableId);
    }
}

