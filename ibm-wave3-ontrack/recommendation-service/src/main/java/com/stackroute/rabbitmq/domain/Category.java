package com.stackroute.rabbitmq.domain;

import com.stackroute.recommendationservice.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Category {
    @Id
    private String productTypeId;
    private String productType;
    @Relationship(type="IS_OF_CATEGORY",direction=Relationship.INCOMING)
    private Product product;
}

