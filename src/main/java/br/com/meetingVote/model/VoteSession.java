package br.com.meetingVote.model;

import br.com.meetingVote.dto.VoteSessionDTO;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tb_voteSession")
public class VoteSession {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date startDate;

    private Integer duration;

    private Date endDate;

    private Long idItem;

    public VoteSession(Long id, Date startDate, Integer duration, Date endDate, Long idItem) {
        this.id = id;
        this.startDate = startDate;
        this.duration = duration;
        this.endDate = endDate;
        this.idItem = idItem;
    }

    public VoteSession(VoteSessionDTO voteSessionDTO){
        this.id = voteSessionDTO.getId();
        this.idItem = voteSessionDTO.getIdItem();
        this.endDate = voteSessionDTO.getEndDate();
        this.startDate = voteSessionDTO.getStartDate();
        this.duration = voteSessionDTO.getDuration();
    }

    public VoteSession(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getIdItem() {
        return idItem;
    }

    public void setIdItem(Long idItem) {
        this.idItem = idItem;
    }
}
