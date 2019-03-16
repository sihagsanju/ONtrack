package com.stackroute.productssearchservice.controller;

import com.stackroute.productssearchservice.domain.Brand;
import com.stackroute.productssearchservice.domain.Product;
import com.stackroute.productssearchservice.exception.ProductAlreadyExistsException;
import com.stackroute.productssearchservice.exception.ProductDoesNotExistsException;
import com.stackroute.productssearchservice.repository.ProductRepository;
import com.stackroute.productssearchservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ProductController {
    ProductService productService;
    private ResponseEntity<?> responseEntity;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }



    @PostMapping("/search-product")
    public ResponseEntity<?> saveProduct(@RequestBody Product product){
        try
        {
            Optional<Brand> product1 =   productService.saveProduct(product);
            return new ResponseEntity<Optional>(product1, HttpStatus.OK);
        }
        catch (ProductAlreadyExistsException e)
        {
            System.out.println(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/search-brand/{brand}")
    public ResponseEntity<?>searchBrandByStartWith(@PathVariable("brand") String brand){
        try {
            return new ResponseEntity<List<Product>>(productService.getAllProductsByStartwithbrand(brand), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }

//
//    @GetMapping("/search-product/{productName}")
//    public ResponseEntity<?>searchProductByStartsWith(@PathVariable("productName") String productName){
//        try {
//            return new ResponseEntity<List<Product>>(productService.getAllProductByStartswith(productName), HttpStatus.OK);
//        }
//        catch (ProductDoesNotExistsException e)
//        {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }

}
