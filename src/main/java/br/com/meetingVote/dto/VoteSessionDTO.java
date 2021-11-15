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
    private Integer totalVote = 0;
    private Integer totalYes = 0;
    private Integer totalNo = 0;

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
        this.totalVote = voteSession.getTotalVote();
        this.totalNo = voteSession.getTotalNo();
        this.totalYes = voteSession.getTotalYes();
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

    public Integer getTotalVote() {
        return totalVote;
    }

    public void setTotalVote(Integer totalVote) {
        this.totalVote = totalVote;
    }

    public Integer getTotalYes() {
        return totalYes;
    }

    public void setTotalYes(Integer totalYes) {
        this.totalYes = totalYes;
    }

    public Integer getTotalNo() {
        return totalNo;
    }

    public void setTotalNo(Integer totalNo) {
        this.totalNo = totalNo;
    }
}
