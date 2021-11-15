package br.com.meetingVote.model;

import br.com.meetingVote.dto.NewPersonDTO;

import javax.persistence.*;

@Entity
@Table(name = "tb_person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String cpf;


    public Person(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public Person() {

    }

    public Person(NewPersonDTO newPersonDTO) {
        this.cpf = newPersonDTO.getCpf();
        this.name = newPersonDTO.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
