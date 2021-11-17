package br.com.meetingVote.controller;

import br.com.meetingVote.dto.NewVoteDTO;
import br.com.meetingVote.dto.VoteDTO;
import br.com.meetingVote.dto.VoteSessionDTO;
import br.com.meetingVote.service.PersonService;
import br.com.meetingVote.service.VoteService;
import br.com.meetingVote.service.VoteSessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/vote")
@Api(value = "API Voto")
public class VoteController {
    private VoteService voteService;
    private PersonService personService;
    private VoteSessionService voteSessionService;

    public VoteController(VoteService voteService, PersonService personService, VoteSessionService voteSessionService) {
        this.voteService = voteService;
        this.personService = personService;
        this.voteSessionService = voteSessionService;
    }

    @GetMapping("/")
    @ApiOperation(value = "Retorna todos votos registrados")
    public List<VoteDTO> getAllVote() {
        return voteService.findAll();
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Retorna todo voto registrado através do ID do Item")
    public VoteDTO getVoteByIdItem(@PathVariable Long idItem) {
        return voteService.findByIdItem(idItem);
    }

    @GetMapping("person/{id}")
    @ApiOperation(value = "Retorna todos votos registrados através do Id da pessoa")
    public VoteDTO getVoteByIdPerson(@PathVariable Long idPerson) {
        return voteService.findByIdPerson(idPerson);
    }

    @GetMapping("flVote/{flVote}")
    @ApiOperation(value = "Retorna todos votos registrados através Status do Voto")
    public VoteDTO getVoteByFlVote(@PathVariable String flVote) {
        return voteService.findByFlVote(flVote);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria um novo voto")
    public ResponseEntity<VoteDTO> createVote(@RequestBody NewVoteDTO newVoteDTO) {
        Calendar calendar = Calendar.getInstance();
        Date currentTime = calendar.getTime();
        VoteSessionDTO voteSessionDTO = voteSessionService.findByIdItem(newVoteDTO.getIdItem());
        if (newVoteDTO.getFlVote().equals("S") || newVoteDTO.getFlVote().equals("N")) {
            if (!voteService.validateVote(newVoteDTO.getIdItem(), newVoteDTO.getIdPerson())) {
                if (voteSessionDTO.getEndDate().after(currentTime)) {
                    if (newVoteDTO.getFlVote().equals("S")) {
                        voteSessionService.totalYes(voteSessionDTO.getId(), voteSessionDTO);
                    } else {
                        voteSessionService.totalNo(voteSessionDTO.getId(), voteSessionDTO);
                    }
                    VoteDTO voteDTO = voteService.createVote(newVoteDTO);
                    voteSessionService.totalVote(voteSessionDTO.getId(), voteSessionDTO);
                    return new ResponseEntity<VoteDTO>(voteDTO, HttpStatus.CREATED);
                }

            }

        }
        return new ResponseEntity<VoteDTO>(HttpStatus.NOT_ACCEPTABLE);
    }


}
