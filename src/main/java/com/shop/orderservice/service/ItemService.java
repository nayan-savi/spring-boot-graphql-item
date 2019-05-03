package com.shop.orderservice.service;

import com.shop.orderservice.model.Item;
import com.shop.orderservice.repository.ItemRepository;
import io.leangen.graphql.annotations.GraphQLMutation;
import io.leangen.graphql.annotations.GraphQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GraphQLQuery(name = "items")
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    @GraphQLQuery(name = "item")
    public Item getItemById(Long id){
        return itemRepository.getOne(id);
    }

    @GraphQLMutation(name = "saveItem")
    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @GraphQLMutation(name = "deleteItem")
    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }
}
