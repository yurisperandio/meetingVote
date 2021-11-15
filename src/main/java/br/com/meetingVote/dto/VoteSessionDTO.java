package br.com.meetingVote.dto;

import br.com.meetingVote.model.Vote;
import br.com.meetingVote.model.VoteSession;

import java.util.Date;
import java.util.List;

public class VoteSessionDTO {

    private Long id;
    private Long idItem;
    private Integer duration;
    private Date startDate;
    private Date endDate;

    public VoteSessionDTO(Vote vote){
        this.duration = vote.getDuration();
        this.endDate = vote.getEndDate();
        this.startDate = vote.getStartDate();
        this.idItem = vote.getIdItem();
    }

    public VoteSessionDTO(){}

    public VoteSessionDTO(VoteSession voteSession) {
        this.id = voteSession.getId();
        this.idItem = voteSession.getIdItem();
        this.startDate = voteSession.getStartDate();
        this.endDate = voteSession.getEndDate();
        this.duration = voteSession.getDuration();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
