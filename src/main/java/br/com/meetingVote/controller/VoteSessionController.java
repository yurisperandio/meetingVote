package br.com.meetingVote.controller;

import br.com.meetingVote.dto.PersonCpfDTO;
import br.com.meetingVote.dto.PersonDTO;
import br.com.meetingVote.dto.VoteResultDTO;
import br.com.meetingVote.dto.VoteSessionDTO;
import br.com.meetingVote.service.VoteSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voteSession")
@Api(value = "Api VoteSession")
public class VoteSessionController {
    VoteSessionService voteSessionService;

    public VoteSessionController(VoteSessionService voteSessionService){
        this.voteSessionService = voteSessionService;
    }

    @GetMapping(value = "/", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Retorna todas as sessões cadastradas")
    public List<VoteSessionDTO> getAllSession(){
        return voteSessionService.findAll();
    }

    @GetMapping(value = "id/{id}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Retorna a sessão por ID da Sessão")
    public VoteSessionDTO getSessionById(@PathVariable Long id){
        return voteSessionService.findByIdSession(id);
    }

    @GetMapping(value = "idItem/{idItem}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Retorna a sessão por Id do Item")
    public VoteSessionDTO getSessionByIdItem(@PathVariable Long idItem){
        return voteSessionService.findByIdItem(idItem);
    }

    @GetMapping(value = "result/{idSession}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Retorna o resultado da sessão")
    public VoteResultDTO result(@PathVariable Long idSession){
        return voteSessionService.result(idSession);
    }

    @PostMapping(value = "createSession", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Cria uma nova sessão")
    public ResponseEntity<VoteSessionDTO> createSession(@RequestBody VoteSessionDTO voteSessionDTO){
        VoteSessionDTO voteSessionDT0 = voteSessionService.createSession(voteSessionDTO);
        return new ResponseEntity<VoteSessionDTO>(voteSessionDT0,HttpStatus.CREATED);
    }

    @PatchMapping(value = "id/{id}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Atualiza os dados de Sessão")
    private VoteSessionDTO updateSession(@PathVariable Long id, @RequestBody VoteSessionDTO voteSessionDTO) {
        return voteSessionService.updateSession(id, voteSessionDTO);
    }

    @DeleteMapping(value = "id/{id}", produces = {"application/vnd.meetingVote.app-v1.0+json"})
    @ApiOperation(value = "Deleta sessão, filtrando pelo ID")
    public void deleteSession(@PathVariable Long id) {
        voteSessionService.deleteSession(id);
    }

}
