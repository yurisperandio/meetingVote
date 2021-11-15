package br.com.meetingVote.dto;

import br.com.meetingVote.model.Item;

public class ItemDTO {

    private Long id;
    private String subject;
    private String description;

    public ItemDTO(Item item){
        this.id = item.getId();
        this.subject = item.getSubject();
        this.description = item.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
