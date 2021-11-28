package ru.alexander.mss.server.model.item.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    private String key;
    private int condition;
    private float weight;
}
