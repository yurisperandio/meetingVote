package br.com.meetingVote.model;

import br.com.meetingVote.dto.NewVoteDTO;
import javax.persistence.*;

@Entity
@Table(name = "tb_vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idPerson;

    private Long idItem;

    private String flVote;

    public Vote(Long id, Long idPerson, Long idItem, String flVote) {
        this.idPerson = idPerson;
        this.idItem = idItem;
        this.flVote = flVote;
        this.id = id;
    }

    public Vote(){

    }

    public Vote(NewVoteDTO newVoteDTO){
        this.idPerson = newVoteDTO.getIdPerson();
        this.idItem = newVoteDTO.getIdItem();
        this.flVote = newVoteDTO.getFlVote();
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
