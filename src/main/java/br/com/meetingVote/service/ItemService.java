package br.com.meetingVote.service;

import br.com.meetingVote.dto.*;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getItem();
    ItemDTO getItemById(Long id);
    ItemDTO getItemBySubject(String subject);
    ItemDTO createItem(NewItemDTO newItemDTO);
    ItemDTO updateSubject(Long id, ItemSubjectDTO itemSubjectDTO);
    ItemDTO updateDescription(Long id, ItemDescriptionDTO itemDescriptionDTO);
    void deleteItem(Long id);


}
