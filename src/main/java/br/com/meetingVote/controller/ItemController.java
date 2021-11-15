package br.com.meetingVote.controller;

import br.com.meetingVote.dto.ItemDTO;
import br.com.meetingVote.dto.ItemDescriptionDTO;
import br.com.meetingVote.dto.ItemSubjectDTO;
import br.com.meetingVote.dto.NewItemDTO;
import br.com.meetingVote.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping("/")
    public List<ItemDTO> getAllItem(){
        return itemService.getItem();
    }

    @GetMapping("{id}")
    public ItemDTO getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }

    @GetMapping("{subject/{subject}")
    public ItemDTO getItemBySubject(@PathVariable String subject){
        return itemService.getItemBySubject(subject);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO createItem (@RequestBody NewItemDTO newItemDTO){
        return itemService.createItem(newItemDTO);
    }

    @PutMapping("{id}")
    public ItemDTO updateSubject(@PathVariable Long id, @RequestBody ItemSubjectDTO itemSubjectDTO){
        return itemService.updateSubject(id, itemSubjectDTO);
    }

    @PatchMapping("{id}")
    public ItemDTO updateDescription(@PathVariable Long id, @RequestBody ItemDescriptionDTO itemDescriptionDTO){
        return itemService.updateDescription(id, itemDescriptionDTO);
    }

    @DeleteMapping("{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }

}
