package ru.alexander.mss.server.web.item.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private String id;
    private int condition;
    private float weight;
}
