package br.com.meetingVote.controller;

import br.com.meetingVote.dto.VoteResultDTO;
import br.com.meetingVote.dto.VoteSessionDTO;
import br.com.meetingVote.service.VoteSessionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voteSession")
public class VoteSessionController {
    VoteSessionService voteSessionService;

    public VoteSessionController(VoteSessionService voteSessionService){
        this.voteSessionService = voteSessionService;
    }

    @GetMapping("/")
    public List<VoteSessionDTO> getAllSession(){
        return voteSessionService.findAll();
    }

    @GetMapping("id/{id}")
    public VoteSessionDTO getSessionById(@PathVariable Long id){
        return voteSessionService.findByIdSession(id);
    }

    @GetMapping("idItem/{idItem}")
    public VoteSessionDTO getSessionByIdItem(@PathVariable Long idItem){
        return voteSessionService.findByIdItem(idItem);
    }

    @GetMapping("result/{idSession}")
    public VoteResultDTO result(@PathVariable Long idSession){
        return voteSessionService.result(idSession);
    }

    @PostMapping("createSession")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<VoteSessionDTO> createSession(@RequestBody VoteSessionDTO voteSessionDTO){
        VoteSessionDTO voteSessionDT0 = voteSessionService.createSession(voteSessionDTO);

        return new ResponseEntity<VoteSessionDTO>(voteSessionDT0,HttpStatus.CREATED);
    }

}
