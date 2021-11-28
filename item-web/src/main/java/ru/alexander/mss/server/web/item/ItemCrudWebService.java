package ru.alexander.mss.server.web.item;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.alexander.mss.server.logic.item.ItemCRUDService;
import ru.alexander.mss.server.model.item.entity.Item;
import ru.alexander.mss.server.web.item.dto.ItemDTO;

import java.net.URI;

import static java.util.Optional.ofNullable;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequiredArgsConstructor
class ItemCrudWebService {
    private final ItemCRUDService crudService;

    @GetMapping("/item/{item_id}")
    ResponseEntity<Item> getItem(@PathVariable("item_id") String itemId) {
        return ResponseEntity.of(ofNullable(crudService.getItem(itemId)));
    }

    @PostMapping("/item")
    ResponseEntity<Item> createItem(@RequestBody ItemDTO itemDTO) {
        var item = new Item();
        item.setCondition(itemDTO.getCondition());
        item.setWeight(itemDTO.getWeight());

        item = crudService.saveItem(item);
        return ofNullable(item)
            .map(i -> ResponseEntity.created(URI.create("/item/" + i.getKey())).body(i))
            .orElseGet(() -> badRequest().build());
    }

    @PutMapping("/item")
    ResponseEntity<Item> updateItem(@RequestBody ItemDTO itemDTO) {
        var item = new Item();
        item.setKey(itemDTO.getId());
        item.setCondition(itemDTO.getCondition());
        item.setWeight(itemDTO.getWeight());

        item = crudService.saveItem(item);
        return ResponseEntity.of(ofNullable(item));
    }

    @DeleteMapping("/item/{item_id}")
    ResponseEntity<Object> deleteItem(@PathVariable("item_id") String id) {
        crudService.deleteItem(id);
        return ok().build();
    }
}
