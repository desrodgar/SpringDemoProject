package com.example.demo.web.controller;

import com.example.demo.services.BeerService;
import com.example.demo.web.model.BeerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/v1/beer")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }


    @GetMapping({"/{beerID}"})
    public ResponseEntity<BeerDTO> getBeer(@PathVariable ("beerID") UUID beerID){
        return new ResponseEntity<>(beerService.getBeerByID(beerID), HttpStatus.OK);

    }

}
