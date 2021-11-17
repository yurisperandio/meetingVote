package br.com.meetingVote.controller;

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

    @GetMapping("/")
    @ApiOperation(value = "Retorna todas as sessões cadastradas")
    public List<VoteSessionDTO> getAllSession(){
        return voteSessionService.findAll();
    }

    @GetMapping("id/{id}")
    @ApiOperation(value = "Retorna a sessão por ID da Sessão")
    public VoteSessionDTO getSessionById(@PathVariable Long id){
        return voteSessionService.findByIdSession(id);
    }

    @GetMapping("idItem/{idItem}")
    @ApiOperation(value = "Retorna a sessão por Id do Item")
    public VoteSessionDTO getSessionByIdItem(@PathVariable Long idItem){
        return voteSessionService.findByIdItem(idItem);
    }

    @GetMapping("result/{idSession}")
    @ApiOperation(value = "Retorna o resultado da sessão")
    public VoteResultDTO result(@PathVariable Long idSession){
        return voteSessionService.result(idSession);
    }

    @PostMapping("createSession")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Cria uma nova sessão")
    public ResponseEntity<VoteSessionDTO> createSession(@RequestBody VoteSessionDTO voteSessionDTO){
        VoteSessionDTO voteSessionDT0 = voteSessionService.createSession(voteSessionDTO);

        return new ResponseEntity<VoteSessionDTO>(voteSessionDT0,HttpStatus.CREATED);
    }

}
