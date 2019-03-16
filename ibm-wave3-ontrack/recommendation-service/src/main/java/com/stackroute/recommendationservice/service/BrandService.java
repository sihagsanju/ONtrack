package com.stackroute.recommendationservice.service;

import com.stackroute.rabbitmq.domain.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> getAll();
    public Brand createBrandNode(Brand brand);
}
