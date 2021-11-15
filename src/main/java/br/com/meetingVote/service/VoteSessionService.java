package br.com.meetingVote.service;

import br.com.meetingVote.dto.*;

import java.util.List;

public interface VoteSessionService {

    List<VoteSessionDTO> findAll();
    VoteSessionDTO findByIdItem(Long idItem);
    VoteSessionDTO findByIdSession(Long idSession);
    VoteSessionDTO createSession(VoteSessionDTO voteSessionDTO);
    VoteSessionDTO findEndDateById(VoteSessionDTO voteSessionDTO);
    VoteSessionDTO updateSession(Long id, VoteSessionDTO voteSessionDTO);

}
