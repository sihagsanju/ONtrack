package com.stackroute.productservice.service;

import com.stackroute.rabbitmq.domain.Product;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.exceptions.ProductAlreadyUpdatedException;
import com.stackroute.productservice.exceptions.ProductIdNotFoundException;
import com.stackroute.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override

    public Product saveProduct(Product product) throws ProductAlreadyExistsException {

         if(productRepository.existsById(product.getProductId())){
             throw new ProductAlreadyExistsException("Product already exists");
         }
        Product savedProduct = productRepository.save(product);
         if(savedProduct ==null){
             throw new ProductAlreadyExistsException("Product already exist");
         }
        return savedProduct;
    }
    @Override
    public Product updateProduct(Product product) throws ProductAlreadyUpdatedException {

       if(productRepository.existsById(product.getProductId())){


           throw new ProductAlreadyUpdatedException("Product doesn't exists.");
       }else


                 product.setProductId(product.getProductId());

        return productRepository.save(product);


    }


    @Override
    public boolean deleteProduct(String id) throws ProductIdNotFoundException {
            boolean status=false;
           if(productRepository.existsById(id)){

               productRepository.deleteById(id);

               status=true;
               return status;
           }
           else{
               throw new ProductIdNotFoundException("Product id not found");
           }



    }

    @Override
    public List<Product> getAllProducts()

    {
        return productRepository.findAll();
//                .stream()
//                .map(productMapper::productToProductDTO)
//                .collect(Collectors.toList());
    }



}
