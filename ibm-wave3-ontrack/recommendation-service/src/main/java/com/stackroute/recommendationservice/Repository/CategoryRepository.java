package com.stackroute.recommendationservice.Repository;

import com.stackroute.rabbitmq.domain.Category;
import com.stackroute.recommendationservice.domain.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends Neo4jRepository<Category, String> {
    @Query("match(n:Category) return n")
    List<Category> getAllCategories();

    @Query("MATCH (a:Product),(b:Category) WHERE b.productType = a.productType MERGE (a)-[:IS_OF_CATEGORY]->(b) RETURN a,b")
    Product getAllProducts();

    @Query("Create (c:Category) SET c.id={productId},c.productType={productType}")
    Category createCategoryNode(@Param("productId") String productId, @Param("productType") String productType);
}
