package kokwabeerframework.msscbrewery.services;

import kokwabeerframework.msscbrewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return BeerDto.builder().id(UUID.randomUUID())
                .beerName("Galaxy Cat")
                .beersStyle("Pale Ale")
                .build();
    }
    @Override
    public BeerDto saveNewBeer(BeerDto beerDto){
        return BeerDto.builder().id(UUID.randomUUID())
                .build();
    }


    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto){
        //todo impl updateBeer ;
    }

    @Override
    public void deleteById(UUID beerID) {
        log.debug("Deleting beer ....");
    }

}
