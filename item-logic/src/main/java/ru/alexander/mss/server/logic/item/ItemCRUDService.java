package ru.alexander.mss.server.logic.item;

import ru.alexander.mss.server.model.item.entity.Item;

public interface ItemCRUDService {
    Item getItem(String key);

    Item saveItem(Item item);

    void deleteItem(Item item);

    void deleteItem(String key);
}
