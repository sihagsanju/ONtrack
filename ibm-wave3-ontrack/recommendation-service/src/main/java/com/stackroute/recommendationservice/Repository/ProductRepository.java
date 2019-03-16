package com.stackroute.recommendationservice.Repository;

import com.stackroute.recommendationservice.domain.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends Neo4jRepository<Product, String> {

    @Query("MATCH (n:Product) return n")
    Product getAllProducts();

    @Query("Create (p:Product) SET p.productId={productId},p.productName={productName},p.productType={productType},p.productTypeId={productTypeId},p.imageURL={imageURL},p.mrp={mrp},p.price={price},p.dimension={dimension},p.weight={weight},p.size={size},p.gender={gender},p.description={description},p.brand={brand},p.brandId={brandId},p.colour={colour}")
    Product create(@Param("productId") String productId, @Param("productName") String productName, @Param("productType") String productType, @Param("productTypeId") String productTypeId, @Param("imageURL") String imageURL, @Param("mrp") String mrp, @Param("price") String price, @Param("dimension") String dimension, @Param("weight") String weight, @Param("size") String size, @Param("gender") String gender, @Param("description") String description, @Param("brand") String brand, @Param("brandId") String brandId, @Param("colour") String colour);
}
