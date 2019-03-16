package com.stackroute.rabbitmq.domain;

import com.stackroute.recommendationservice.domain.Product;
import lombok.Data;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@Data
public class Brand {

    @Id
    private String brandId;
    private String brand;
    @Relationship(type="IS_OF_BRAND",direction=Relationship.INCOMING)
    private Product product;

}
