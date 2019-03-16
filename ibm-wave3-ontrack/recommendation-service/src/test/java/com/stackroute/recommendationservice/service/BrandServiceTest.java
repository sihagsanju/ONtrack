package com.stackroute.recommendationservice.service;


import com.stackroute.rabbitmq.domain.Brand;
import com.stackroute.recommendationservice.Repository.BrandRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class BrandServiceTest {
    Brand brands;

    @Mock
    BrandRepository brandRepository;

    @InjectMocks
    BrandServiceImpl brandService;
    List<Brand> list = null;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        brands = new Brand();
        brands.setBrandId("1");
        brands.setBrand("Lavie");
        list = new ArrayList<>();
        list.add(brands);
    }

    @Test
    public void saveBrandTest()
    {
        when(brandRepository.createBrand(brands.getBrandId(),brands.getBrand())).thenReturn(brands);
        Brand savedBrand = brandService.createBrandNode(brands);
        Assert.assertEquals(brands,savedBrand);
    }

    @Test
    public void getBrandTest() {
        brandRepository.createBrand(brands.getBrandId(),brands.getBrand());
        when(brandRepository.findAll()).thenReturn(list);
        List<Brand> userList = brandService.getAllBrand();
        Assert.assertEquals(list, userList);
    }
}





