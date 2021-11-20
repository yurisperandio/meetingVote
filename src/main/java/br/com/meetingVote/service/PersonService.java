package br.com.meetingVote.service;

import br.com.meetingVote.dto.NewPersonDTO;
import br.com.meetingVote.dto.PersonCpfDTO;
import br.com.meetingVote.dto.PersonDTO;
import br.com.meetingVote.dto.PersonNameDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getPerson();
    PersonDTO getPersonByCpf(String cpf);
    List<PersonDTO> getPersonByName(String name);
    PersonDTO createPerson(NewPersonDTO newPersonDTO);
    PersonDTO updateName(Long id, PersonNameDTO PersonNameDTO);
    PersonDTO updateCpf(Long id, PersonCpfDTO PersonCpfDTO);
    void deletePerson(Long id);
    Boolean validateCPF(String cpf);
}
