package br.com.meetingVote.service;

import br.com.meetingVote.dto.NewVoteDTO;
import br.com.meetingVote.dto.VoteDTO;

import java.util.List;

public interface VoteService {
    List<VoteDTO> findAll();
    VoteDTO findByIdPerson(Long idPerson);
    VoteDTO findByIdItem(Long idItem);
    VoteDTO findByFlVote(String flVote);
    VoteDTO createVote(NewVoteDTO newVoteDTO);
    Boolean validateVote(Long idItem, Long idPerson);
}
