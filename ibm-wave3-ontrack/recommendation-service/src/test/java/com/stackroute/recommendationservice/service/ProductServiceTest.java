package com.stackroute.recommendationservice.service;




import com.stackroute.recommendationservice.Repository.ProductRepository;
import com.stackroute.recommendationservice.domain.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;


import static org.mockito.Mockito.*;

public class ProductServiceTest {
    Product product;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    ProductServiceImpl productService;
    List<Product> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        product = new Product();
        product.setProductId("1");
        product.setProductName("Shoe");
        product.setProductType("good");
        product.setProductTypeId("1");
        product.setImageURL("hkjh nkj");
        product.setMrp("2000");
        product.setPrice("1499");
        product.setDimension("14*10*5");
        product.setWeight("750gm");
        product.setSize("4,5,6,7,8,9");
        product.setGender("Women");
        product.setDescription("Raymond shoes for Women");
        product.setBrand("Raymond");
        product.setBrandId("1");
        product.setColour("Black");

        list = new ArrayList<> ();
        list.add(product);
    }

    @Test
    public void saveProductTest()
    {
        when(productRepository.create(product.getProductId(),product.getProductName(),product.getProductType(),product.getProductTypeId(),product.getImageURL(),product.getMrp(),product.getPrice(),product.getDimension(),product.getWeight(),product.getSize(),product.getGender(),product.getDescription(),product.getBrand(),product.getBrandId(),product.getColour())).thenReturn(product);
        Product savedProduct = productService.createNode(product);
        Assert.assertEquals(product,savedProduct);
    }

    @Test
    public void getProductTest() {
        productRepository.create(product.getProductId(),product.getProductName(),product.getProductType(),product.getProductTypeId(),product.getImageURL(),product.getMrp(),product.getPrice(),product.getDimension(),product.getWeight(),product.getSize(),product.getGender(),product.getDescription(),product.getBrand(),product.getBrandId(),product.getColour());
        when(productRepository.findAll()).thenReturn(list);
        List<Product> productList = productService.getAll();
        Assert.assertEquals(list, productList);
    }
}
