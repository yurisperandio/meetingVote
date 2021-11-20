package br.com.meetingVote.dto;

import java.io.Serializable;
import java.util.Date;

public class NewVoteDTO implements Serializable{

    private Long idPerson;
    private Long idItem;
    private String flVote;
    private Date startDate;

    private Integer duration;

    private Date endDate;

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
