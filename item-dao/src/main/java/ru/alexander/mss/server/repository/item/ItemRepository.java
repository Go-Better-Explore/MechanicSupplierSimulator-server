package ru.alexander.mss.server.repository.item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.alexander.mss.server.model.item.entity.Item;

@Repository
public interface ItemRepository extends CrudRepository<Item, String> {
}
