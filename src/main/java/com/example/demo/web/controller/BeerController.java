package com.example.demo.web.controller;

import com.example.demo.services.BeerService;
import com.example.demo.web.model.BeerDTO;
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

    @GetMapping({"/{beerID}"})
    public ResponseEntity<BeerDTO> getBeer(@PathVariable ("beerID") UUID beerID){
        return new ResponseEntity<>(beerService.getBeerByID(beerID), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<BeerDTO> handlePost (@RequestBody BeerDTO beerDTO){
        BeerDTO savedDto = beerService.saveNewBeer(beerDTO);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/beer" + savedDto.getId().toString());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);


    }

    @PutMapping({"/beerID"})
    public ResponseEntity handleUpdate (@PathVariable ("beerID") UUID beerID, BeerDTO beerDTO){
        beerService.updateBeer(beerID, beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
