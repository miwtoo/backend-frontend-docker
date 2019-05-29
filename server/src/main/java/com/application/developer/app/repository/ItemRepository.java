package com.application.developer.app.repository;

import com.application.developer.app.entity.Item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "*")
public interface ItemRepository extends JpaRepository <Item, Long>{

    
}