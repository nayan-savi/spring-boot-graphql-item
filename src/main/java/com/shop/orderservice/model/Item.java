package com.shop.orderservice.model;

import io.leangen.graphql.annotations.GraphQLQuery;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Item {
    @Id
    @GeneratedValue
    @GraphQLQuery(name = "id", description = "item id")
    private Long id;
    @GraphQLQuery(name = "itemName", description = "item name")
    private @NonNull String itemName;
    @GraphQLQuery(name = "quantity", description = "item quantity")
    private @NonNull int quantity;
    @GraphQLQuery(name = "price", description = "price of the item")
    private @NonNull double price;
}
