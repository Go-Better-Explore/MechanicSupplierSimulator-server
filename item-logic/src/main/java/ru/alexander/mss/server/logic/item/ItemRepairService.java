package ru.alexander.mss.server.logic.item;

import ru.alexander.mss.server.model.item.entity.Item;

public interface ItemRepairService {
    Item repair(Item item);

    Item repair(String key);
}
