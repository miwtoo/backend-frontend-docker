package com.application.developer.app.controller;

import java.util.Collection;
import java.util.Map;

import com.application.developer.app.entity.Item;
import com.application.developer.app.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired private ItemRepository itemRepository;

    @GetMapping("/items")
    public Collection<Item> getAllItems() {
        System.out.println("get all");
        return itemRepository.findAll();
    }

    @PostMapping("/items")
    public Item postItem(@RequestBody Map<String, String> body) {
        Item item = new Item();
        item.setName(body.get("name").toString());
        item.setUrl(body.get("url").toString());
        System.out.println(item);
        return itemRepository.save(item);
    }
    
}