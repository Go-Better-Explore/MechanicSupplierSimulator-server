package ru.alexander.mss.server.logic.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexander.mss.server.model.item.entity.Item;
import ru.alexander.mss.server.repository.item.ItemRepository;

@Service
@RequiredArgsConstructor
class ItemCRUDServiceImpl implements ItemCRUDService {
    private final ItemRepository repository;

    @Override
    public Item getItem(String key) {
        return repository.findById(key).orElse(null);
    }

    @Override
    public Item saveItem(Item item) {
        return repository.save(item);
    }

    @Override
    public void deleteItem(Item item) {
        deleteItem(item.getKey());
    }

    @Override
    public void deleteItem(String key) {
        if (key == null || key.isBlank()) {
            return;
        }
        repository.deleteById(key);
    }
}
