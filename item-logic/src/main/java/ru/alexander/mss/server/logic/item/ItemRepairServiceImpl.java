package ru.alexander.mss.server.logic.item;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.alexander.mss.server.model.item.entity.Item;
import ru.alexander.mss.server.repository.item.ItemRepository;

import static ru.alexander.mss.server.logic.item.Constants.MAX_CONDITION;

@Service
@RequiredArgsConstructor
class ItemRepairServiceImpl implements ItemRepairService {
    private final ItemRepository repository;

    @Override
    public Item repair(Item item) {
        item.setCondition(MAX_CONDITION);
        return repository.save(item);
    }
}
