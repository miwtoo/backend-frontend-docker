package com.application.developer.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@NoArgsConstructor
@Getter @Setter
@Data
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String url;


    public Item(String name, String url) {
        this.name = name;
        this.url = url;
    }
}