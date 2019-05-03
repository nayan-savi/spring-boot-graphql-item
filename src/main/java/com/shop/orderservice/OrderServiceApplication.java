package com.shop.orderservice;

import com.shop.orderservice.model.Item;
import com.shop.orderservice.service.ItemService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    ApplicationRunner init(ItemService itemService) {
        Item item1 = new Item();item1.setItemName("Apple");item1.setQuantity(1);item1.setPrice(20.0);
        itemService.saveItem(item1);
        Item item2 = new Item();item2.setItemName("Chair");item2.setQuantity(2);item2.setPrice(1220.0);
        itemService.saveItem(item2);
        Item item3 = new Item();item3.setItemName("sony tv");item3.setQuantity(1);item3.setPrice(51350.0);
        itemService.saveItem(item3);
        Item item4 = new Item();item4.setItemName("washing machine");item4.setQuantity(1);item4.setPrice(32500.0);
        itemService.saveItem(item4);
        System.out.println(itemService.getItems().size() +" items are added in the bucket...");
        return args -> {
            Stream.of(item1, item2, item3, item4).forEach(item -> {
                itemService.saveItem(item);
            });
            itemService.getItems().forEach(System.out::println);
        };
    }

}
