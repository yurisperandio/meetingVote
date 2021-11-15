package br.com.meetingVote.service.impl;

import br.com.meetingVote.dto.*;
import br.com.meetingVote.model.Item;
import br.com.meetingVote.repository.ItemRepository;
import br.com.meetingVote.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @Override
    public List<ItemDTO> getItem() {
        List<Item> itemList;
        itemList = (List<Item>) itemRepository.findAll();
        return itemList.stream().map(ItemDTO::new).collect(Collectors.toList());
    }

    @Override
    public ItemDTO getItemById(Long id) {
        Item item = itemRepository.findItemById(id);
        return new ItemDTO(item);
    }

    @Override
    public ItemDTO getItemBySubject(String subject) {
        Item item = itemRepository.findItemBySubject(subject);
        return new ItemDTO(item);
    }

    @Override
    public ItemDTO createItem(NewItemDTO newItemDTO) {
        Item item = new Item(newItemDTO);
        Item itemSaved = itemRepository.save(item);
        return new ItemDTO(itemSaved);
    }

    @Override
    public ItemDTO updateSubject(Long id, ItemSubjectDTO itemSubjectDTO) {
        Item item = itemRepository.findItemById(id);
        item.setSubject(itemSubjectDTO.getSubject());
        Item itemSaved = itemRepository.save(item);
        return new ItemDTO(itemSaved);
    }

    @Override
    public ItemDTO updateDescription(Long id, ItemDescriptionDTO itemDescriptionDTO) {
        Item item = itemRepository.findItemById(id);
        item.setDescription(itemDescriptionDTO.getDescription());
        Item itemSaved = itemRepository.save(item);
        return new ItemDTO(itemSaved);
    }

    @Override
    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }
}
