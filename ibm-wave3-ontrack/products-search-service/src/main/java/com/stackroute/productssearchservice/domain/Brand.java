package com.stackroute.productssearchservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(value = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brand {
    @Id
    private String brand;
    private List<Product> list;

    @Override
    public String toString() {
        return "Brand{" +
                "brand='" + brand + '\'' +
                ", list=" + list +
                '}';
    }
}
