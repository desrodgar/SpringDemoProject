package com.example.demo.services;

import com.example.demo.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerByID(UUID beerID) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerStyle("dry")
                .beerName("Paulaner")
                .build();

    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return BeerDTO.builder()
                .id(UUID.randomUUID())
                .build();
    }


}
