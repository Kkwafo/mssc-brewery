package kokwabeerframework.msscbrewery.web.controller;

import kokwabeerframework.msscbrewery.services.CustomerService;
import kokwabeerframework.msscbrewery.web.model.CustomerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerId") UUID customerId){
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);
    }
    @PostMapping //Create New Customer
    public ResponseEntity handlePost(@RequestBody CustomerDto customerDto){
        CustomerDto saveDto = customerService.saveNewCustomer(customerDto);
        HttpHeaders headers = new HttpHeaders();
        //todo add HostName to URL
        headers.add("Location", "api/v1/customer" + saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);

    }
    @PutMapping({"/{customerId}"})
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("customerId") UUID customerId, @RequestBody CustomerDto customerDto){
        customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{customerId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId")UUID customerId){
        customerService.deleteCustomer(customerId);
    }
}
