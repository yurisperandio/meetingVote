package br.com.meetingVote.model;

import br.com.meetingVote.dto.NewItemDTO;

import javax.persistence.*;

@Entity
@Table(name = "tb_item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    private String subject;

    public Item(String description, String subject) {
        this.description = description;
        this.subject = subject;
    }
    public Item() {
    }

    public Item(NewItemDTO newItemDTO) {
        this.subject = newItemDTO.getSubject();
        this.description = newItemDTO.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
