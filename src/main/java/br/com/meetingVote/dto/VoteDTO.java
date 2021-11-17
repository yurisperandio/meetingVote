package br.com.meetingVote.dto;

import br.com.meetingVote.model.Vote;

import java.util.Date;

public class VoteDTO {
    private Long id;
    private Long idPerson;
    private Long idItem;
    private String flVote;

    public VoteDTO(Vote vote) {
        this.id = vote.getId();
        this.idPerson = vote.getIdPerson();
        this.idItem = vote.getIdItem();
        this.flVote = vote.getFlVote();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public String getFlVote() {
        return flVote;
    }

    public void setFlVote(String flVote) {
        this.flVote = flVote;
    }


}
