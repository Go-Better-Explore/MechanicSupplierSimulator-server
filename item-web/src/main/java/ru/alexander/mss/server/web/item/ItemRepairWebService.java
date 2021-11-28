package ru.alexander.mss.server.web.item;

import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import ru.alexander.mss.server.logic.item.ItemRepairService;
import ru.alexander.mss.server.model.item.entity.Item;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequiredArgsConstructor
class ItemRepairWebService {
    private final ItemRepairService repairService;

    @PutMapping("/item/repair/{item_id}")
    ResponseEntity<Item> repair(@PathVariable(name = "item_id") String itemId) {
        val repairedItem = repairService.repair(itemId);
        return repairedItem == null ? notFound().build() : ok(repairedItem);
    }
}
