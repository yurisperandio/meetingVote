package br.com.meetingVote.service.impl;

import br.com.meetingVote.dto.NewVoteDTO;
import br.com.meetingVote.dto.VoteDTO;
import br.com.meetingVote.dto.VoteSessionDTO;
import br.com.meetingVote.model.Vote;
import br.com.meetingVote.model.VoteSession;
import br.com.meetingVote.repository.VoteRepository;
import br.com.meetingVote.service.ItemService;
import br.com.meetingVote.service.VoteService;
import br.com.meetingVote.service.VoteSessionService;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    private final PersonServiceImpl personService;
    private final ItemService itemService;
    private final VoteSessionService voteSessionService;

    public VoteServiceImpl(VoteRepository voteRepository, PersonServiceImpl personService, ItemService itemService, VoteSessionService voteSessionService) {
        this.voteRepository = voteRepository;
        this.personService = personService;
        this.itemService = itemService;
        this.voteSessionService = voteSessionService;
    }

    @Override
    public List<VoteDTO> findAll() {
        List<Vote> voteList;
        voteList = voteRepository.findAll();
        return voteList.stream().map(VoteDTO::new).collect(Collectors.toList());
    }

    @Override
    public VoteDTO findByIdPerson(Long idPerson) {
        Vote vote = voteRepository.findVoteByIdPerson(idPerson);
        return new VoteDTO(vote);
    }

    @Override
    public VoteDTO findByIdItem(Long idItem) {
        Vote vote = voteRepository.findVoteByIdItem(idItem);
        return new VoteDTO(vote);
    }

    @Override
    public VoteDTO findByFlVote(String flVote) {
        Vote vote = voteRepository.findVoteByFlVote(flVote);
        return new VoteDTO(vote);
    }

    @Override
    public VoteDTO createVote(NewVoteDTO newVoteDTO) {
        Vote vote = new Vote(newVoteDTO);
        Vote voteSaved = voteRepository.save(vote);
        return new VoteDTO(voteSaved);
    }

    @Override
    public Boolean validateVote(Long idItem, Long idPerson){
        Vote vote = voteRepository.findVoteByIdItemAndIdPerson(idItem,idPerson);
        if(vote != null){
            return true;
        }
        return false;
    }



}
