package kokwabeerframework.msscbrewery.web.controller;


import kokwabeerframework.msscbrewery.services.BeerService;
import kokwabeerframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {
    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity<BeerDto> getBeer(@PathVariable("beerId") UUID beerId){
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);

    }

    @PostMapping //Create New Beer

    public ResponseEntity handlePost (BeerDto beerDto){

        BeerDto saveDto= beerService.saveNewBeer(beerDto);

        HttpHeaders headers = new HttpHeaders();
        //todo add hostname to URL
        headers.add( "Location",  "/api/v1/beer" + saveDto.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
