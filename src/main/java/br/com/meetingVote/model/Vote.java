package br.com.meetingVote.model;

import br.com.meetingVote.dto.NewVoteDTO;
import br.com.meetingVote.dto.VoteSessionDTO;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_vote")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long idPerson;

    private Long idItem;

    private Date startDate;

    private Integer duration;

    private Date endDate;

    private String flVote;

    public Vote(Long idPerson, Long idItem, Date startDate, Date endDate, Integer duration, String flVote) {
        this.idPerson = idPerson;
        this.idItem = idItem;
        this.flVote = flVote;
        this.startDate = startDate;
        this.endDate = endDate;
        this.duration = duration;
    }

    public Vote(){

    }

    public Vote(NewVoteDTO newVoteDTO){
        this.idPerson = newVoteDTO.getIdPerson();
        this.idItem = newVoteDTO.getIdItem();
        this.flVote = newVoteDTO.getFlVote();
        this.duration = newVoteDTO.getDuration();
        this.startDate = newVoteDTO.getStartDate();
        this.endDate = newVoteDTO.getEndDate();
    }

    public Vote(VoteSessionDTO voteSessionDTO){
        this.endDate = voteSessionDTO.getEndDate();
        this.startDate = voteSessionDTO.getStartDate();
        this.duration = voteSessionDTO.getDuration();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
