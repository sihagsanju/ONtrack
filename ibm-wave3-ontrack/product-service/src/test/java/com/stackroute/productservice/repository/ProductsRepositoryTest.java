
package com.stackroute.productservice.repository;

import com.stackroute.rabbitmq.domain.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;


@RunWith(SpringRunner.class)
@DataMongoTest
public class ProductsRepositoryTest {

    @Autowired
    private ProductRepository productRepository;
    private Product product;

    @Before
    public void setUp()
    {
        this.product = new Product();
        this.product.setProductId("100");
       this.product.setProductName("Raymond shoe");
        this.product.setProductType("good");
        this.product.setProductTypeId("12");
        this.product.setImageURL("hkjh nkj");
        this.product.setMrp("2000");
        this.product.setPrice("1499");
        this.product.setDimension("14*10*5");
        this.product.setWeight("750gm");
        this.product.setSize("4,5,6,7,8,9");
        this.product.setGender("Women");
        this.product.setDescription("Raymond shoes for Women");
        this.product.setBrand("Raymond");
        this.product.setBrandId("10");
        this.product.setColour("Black");
    }
    @After
    public void tearDown(){

        this.productRepository.deleteAll();
    }

    @Test
    public void testSaveProduct(){
        this.productRepository.save(this.product);
        Product fetchProducts = this.productRepository.findById(this.product.getProductId()).get();
        Assert.assertEquals("100", fetchProducts.getProductId());

    }



    @Test
    public void testSaveProductFailure(){

        this.product = new Product();
        this.product.setProductId("10000");
        this.product.setProductName("Raymond shoe");
        this.product.setProductType("good");
        this.product.setProductTypeId("12");
        this.product.setImageURL("hkjh nkj");
        this.product.setMrp("2000");
        this.product.setPrice("1499");
        this.product.setDimension("14*10*5");
        this.product.setWeight("750gm");
        this.product.setSize("4,5,6,7,8,9");
        this.product.setGender("Women");
        this.product.setDescription("Raymond shoes for Women");
        this.product.setBrand("Raymond");
        this.product.setBrandId("10");
        this.product.setColour("Black");
        this.productRepository.save(product);
        Product fetchUser = this.productRepository.findById(this.product.getProductId()).get();
        Assert.assertNotSame(fetchUser, this.product);
    }

    @Test
    public void testGetAllProductsSuccess(){

        this.product = new Product();
        this.product.setProductId("10000");
        this.product.setProductName("Bata Shoe for women");
        this.product.setProductType("good");
        this.product.setProductTypeId("12");
        this.product.setImageURL("hkjh nkj");
        this.product.setMrp("2000");
        this.product.setPrice("1499");
        this.product.setDimension("14*10*5");
        this.product.setWeight("750gm");
        this.product.setSize("4,5,6,7,8,9");
        this.product.setGender("Women");
        this.product.setDescription("Raymond shoes for Women");
        this.product.setBrand("Raymond");
        this.product.setBrandId("10");
        this.product.setColour("Black");
        this.productRepository.save(product);


        List<Product> list = this.productRepository.findAll();
        Assert.assertEquals("Bata Shoe for women",product.getProductName());

    }
    @Test
    public void testGetAllProductsFailure(){

        this.product = new Product();
        this.product.setProductId("10000");
        this.product.setProductName("Bata Shoe for women");
        this.product.setProductType("good");
        this.product.setProductTypeId("12");
        this.product.setImageURL("hkjh nkj");
        this.product.setMrp("2000");
        this.product.setPrice("1499");
        this.product.setDimension("14*10*5");
        this.product.setWeight("750gm");
        this.product.setSize("4,5,6,7,8,9");
        this.product.setGender("Women");
        this.product.setDescription("Raymond shoes for Women");
        this.product.setBrand("Raymond");
        this.product.setBrandId("10");
        this.product.setColour("Black");
        this.productRepository.save(product);


        List<Product> list = this.productRepository.findAll();
        Assert.assertNotEquals("Raymond",product.getProductName());

    }
}
