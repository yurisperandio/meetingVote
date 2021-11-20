package br.com.meetingVote.controller;

import br.com.meetingVote.dto.ItemDTO;
import br.com.meetingVote.dto.ItemDescriptionDTO;
import br.com.meetingVote.dto.ItemSubjectDTO;
import br.com.meetingVote.dto.NewItemDTO;
import br.com.meetingVote.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@Api(value = "API Person")
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping(value = "/", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Retorna todos itens cadastrados")
    public List<ItemDTO> getAllItem(){
        return itemService.getItem();
    }

    @GetMapping(value = "{id}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Retorna item por ID")
    public ItemDTO getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }

    @GetMapping(value = "{subject/{subject}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Retorna item pelo Assunto")
    public ItemDTO getItemBySubject(@PathVariable String subject){
        return itemService.getItemBySubject(subject);
    }

    @PostMapping(produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cadastra novo item")
    public ItemDTO createItem (@RequestBody NewItemDTO newItemDTO){
        return itemService.createItem(newItemDTO);
    }

    @PutMapping(value = "{id}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Atualiza o assunto do item cadastrado")
    public ItemDTO updateSubject(@PathVariable Long id, @RequestBody ItemSubjectDTO itemSubjectDTO){
        return itemService.updateSubject(id, itemSubjectDTO);
    }

    @PatchMapping(value = "{id}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Atualiza a descrição do item cadastrado")
    public ItemDTO updateDescription(@PathVariable Long id, @RequestBody ItemDescriptionDTO itemDescriptionDTO){
        return itemService.updateDescription(id, itemDescriptionDTO);
    }

    @DeleteMapping(value = "{id}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Deleta um item, passando o ID como parâmetro")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItem(id);
    }

}
