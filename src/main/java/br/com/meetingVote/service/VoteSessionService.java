package br.com.meetingVote.service;

import br.com.meetingVote.dto.*;

import java.util.List;

public interface VoteSessionService {

    List<VoteSessionDTO> findAll();
    VoteSessionDTO findByIdItem(Long idItem);
    VoteSessionDTO findByIdSession(Long idSession);
    VoteSessionDTO createSession(VoteSessionDTO voteSessionDTO);
    VoteSessionDTO totalVote(Long idSession,VoteSessionDTO voteSessionDTO);
    VoteSessionDTO totalYes(Long idSession,VoteSessionDTO voteSessionDTO);
    VoteSessionDTO totalNo(Long idSession, VoteSessionDTO voteSessionDTO);
    VoteResultDTO result(Long idSession);
    VoteSessionDTO updateSession(Long id, VoteSessionDTO voteSessionDTO);
    void deleteSession(Long id);

}
