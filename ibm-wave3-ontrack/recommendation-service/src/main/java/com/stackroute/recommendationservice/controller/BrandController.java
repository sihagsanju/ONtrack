package com.stackroute.recommendationservice.controller;


import com.stackroute.rabbitmq.domain.Brand;
import com.stackroute.recommendationservice.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BrandController {

    BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("brand")
    public ResponseEntity<?> getAll()
    {
        return new ResponseEntity<List<Brand>>(brandService.getAll(), HttpStatus.OK);
    }

    @PostMapping("brand")
    public ResponseEntity<?> create(@RequestBody Brand brand)
    {
        ResponseEntity responseEntity;
        brandService.createBrandNode(brand);
        responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
        return responseEntity;
    }
}
