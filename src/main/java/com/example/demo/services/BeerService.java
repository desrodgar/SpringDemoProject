package com.example.demo.services;

import com.example.demo.web.model.BeerDTO;

import java.util.UUID;

public interface BeerService {

    BeerDTO getBeerByID(UUID beerID);

    BeerDTO saveNewBeer(BeerDTO beerDTO);

    void updateBeer(UUID beerID, BeerDTO beerDTO);
}
