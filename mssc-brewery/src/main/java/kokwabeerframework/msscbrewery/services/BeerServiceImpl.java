package kokwabeerframework.msscbrewery.services;

import kokwabeerframework.msscbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

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
    public BeerDto updatewBeer(BeerDto beerDto) {
        return null;
    }

    @Override
    public void updateBeer(UUID beerId, BeerDto beerDto){
        //todo impl updateBeer ;
    }
}
