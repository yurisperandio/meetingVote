package br.com.meetingVote.dto;

import br.com.meetingVote.model.VoteSession;

public class VoteResultDTO {
    private Long idSession;
    private Integer totalVote = 0;
    private Integer totalYes = 0;
    private Integer totalNo = 0;

    public VoteResultDTO(VoteSession voteSession){
        this.idSession = voteSession.getId();
        this.totalVote = voteSession.getTotalVote();
        this.totalNo = voteSession.getTotalNo();
        this.totalYes = voteSession.getTotalYes();
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

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }
}
