package br.com.meetingVote.repository;

import br.com.meetingVote.model.Vote;
import br.com.meetingVote.model.VoteSession;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoteSessionRepository extends CrudRepository<VoteSession, Long> {

    List<VoteSession> findAll();

    @Query(value = "select vs from VoteSession vs where vs.idItem = :idItem")
    VoteSession findByIdItem(Long idItem);

    @Query(value = "select vs from VoteSession vs where vs.id = :id")
    VoteSession findByIdSession(Long id);


}
