package com.stackroute.productservice.seeddata;

import com.opencsv.CSVReaderBuilder;

import com.stackroute.rabbitmq.domain.Product;
import com.stackroute.productservice.exceptions.ProductAlreadyExistsException;
import com.stackroute.productservice.service.ProductService;

import com.stackroute.productservice.service.RabbitMqProducer;
import com.stackroute.rabbitmq.domain.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import com.opencsv.CSVReader;

@Component
public class FeedDataApplicationListerer implements ApplicationListener <ContextRefreshedEvent> {

    private ProductService productService;
    private Product product;

    @Autowired
    RabbitMqProducer rabbitMqProducer;

    @Autowired
    public FeedDataApplicationListerer(ProductService productService) throws ProductAlreadyExistsException {
       this.productService=productService;

        this.product = new Product();
        this.product.setProductId("10000000");
        this.product.setProductName("Nike shoe");
        this.product.setProductType("sports shoe");
        this.product.setProductTypeId("101");
        this.product.setImageURL("");
        this.product.setMrp("2000");
        this.product.setPrice("1499");
        this.product.setDimension("14*10*5");
        this.product.setWeight("780gm");
        this.product.setSize("6,7,8,9,10");
        this.product.setGender("Men");
        this.product.setDescription("nike men shoe");
        this.product.setBrand("Nike");
        this.product.setBrandId("112");
        this.product.setColour("Green");


       productService.saveProduct(product);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {

        File file = new File("./assets/ProductSeeddataSheet.csv");
        System.out.println("File Exists : " + file.exists());

       try{
        FileReader filereader = new FileReader(file);

        CSVReader csvReader = new CSVReaderBuilder(filereader)
                .withSkipLines(1)
                .build();
        List<String[]> allData = csvReader.readAll();

           System.out.println("ohsad"+allData.size());


        for (String[] row : allData) {

            System.out.println("values"+Arrays.toString(row));

                product.setProductId(row[0]);
                product.setProductName(row[1]);
                product.setProductType(row[2]);
                product.setProductTypeId(row[3]);
                product.setImageURL(row[4]);
                product.setMrp(row[5]);
                product.setPrice(row[6]);
                product.setDimension(row[7]);
                product.setWeight(row[8]);
                product.setSize(row[9]);
                product.setGender(row[10]);
                product.setDescription(row[11]);
                product.setBrand(row[12]);
                product.setBrandId(row[13]);
                product.setColour(row[14]);
                productService.saveProduct(product);
            rabbitMqProducer.produce(product);
            System.out.println("productDTO values"+ product);

        }
    }
   catch (IOException | ProductAlreadyExistsException ex) {
        ex.printStackTrace();
    }
    }


}
