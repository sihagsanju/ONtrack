package com.stackroute.productssearchservice.service;

import com.stackroute.productssearchservice.domain.Brand;
import com.stackroute.productssearchservice.domain.Product;
import com.stackroute.productssearchservice.exception.BrandDoesNotExists;
import com.stackroute.productssearchservice.exception.ProductAlreadyExistsException;
import com.stackroute.productssearchservice.exception.ProductDoesNotExistsException;
import com.stackroute.productssearchservice.repository.BrandRepository;
import com.stackroute.productssearchservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    BrandRepository brandRepository;

    @Autowired
    public ProductServiceImpl(BrandRepository brandRepository){
        this.brandRepository=brandRepository;
    }

    @Override
    public Optional<Brand> saveProduct(Product product) throws ProductAlreadyExistsException {

        if(brandRepository.existsById(product.getBrand()))
        {
            Optional<Brand> productBrand = brandRepository.findById(product.getBrand());
            System.out.println("get the value of list"+ productBrand.get().getList());
            productBrand.get().getList().add(product);
            brandRepository.save(productBrand.get());
            return productBrand;
//            return productBrand;
        }

        else {
            Brand productBrand= new Brand();
            productBrand.setBrand(product.getBrand());
            List<Product> productList= new ArrayList<>();
            productList.add(product);
            productBrand.setList(productList);
            brandRepository.save(productBrand);
        }

        return null;
    }

//    @Override
//    public List<Product> getAllProductByStartswith(String productName) throws ProductDoesNotExistsException {
//        return null;
//    }

    @Override
    public List<Product> getAllProductByStartswith(String productName) throws ProductDoesNotExistsException {
       List<Product> products=brandRepository.searchByProductAlphabet(productName);
       if(products==null)
           throw new ProductDoesNotExistsException("No ProductFound");
       else
        return products;
    }

    @Override
    public List<Product> getAllProductsByStartwithbrand(String brand) throws BrandDoesNotExists {
        Brand productBrand=brandRepository.searchBrandByName(brand);
        if(productBrand==null) {
            throw new BrandDoesNotExists("No Brand Found");
        }
        List<Product> products= productBrand.getList();
        return products;

    }
}
