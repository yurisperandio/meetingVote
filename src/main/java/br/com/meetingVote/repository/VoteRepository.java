package br.com.meetingVote.repository;

import br.com.meetingVote.model.Vote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VoteRepository extends CrudRepository<Vote, Long> {
    List<Vote> findAll();

    @Query(value = "select v from Vote v where v.idPerson = :idPerson")
    Vote findVoteByIdPerson(Long id);

    @Query(value = "select v from Vote v where v.idItem = :idItem")
    Vote findVoteByIdItem(Long id);

    @Query(value = "select v from Vote v where v.flVote = :flVote")
    Vote findVoteByFlVote(String flVote);

    @Query(value = "select v from Vote v where v.idItem = :idItem and v.idPerson = :idPerson")
    Vote findVoteByIdItemAndIdPerson(Long idItem, Long idPerson);



}
