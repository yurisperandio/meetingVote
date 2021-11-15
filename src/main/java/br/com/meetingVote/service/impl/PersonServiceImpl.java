package br.com.meetingVote.service.impl;

import br.com.meetingVote.dto.NewPersonDTO;
import br.com.meetingVote.dto.PersonCpfDTO;
import br.com.meetingVote.dto.PersonDTO;
import br.com.meetingVote.dto.PersonNameDTO;
import br.com.meetingVote.model.Person;
import br.com.meetingVote.repository.PersonRepository;
import br.com.meetingVote.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Override
    public List<PersonDTO> getPerson() {
        List<Person> personList;
        personList = (List<Person>) personRepository.findAll();
        return personList.stream().map(PersonDTO::new).collect(Collectors.toList());
    }

    @Override
    public PersonDTO getPersonByCpf(String cpf) {
        Person person = personRepository.findPersonByCpf(cpf);
        return new PersonDTO(person);
    }


    @Override
    public PersonDTO getPersonByName(String name) {
        Person person = personRepository.findPersonByName(name);
        return new PersonDTO(person);
    }


    @Override
    public PersonDTO updateName(Long id, PersonNameDTO personNameDTO) {
        Person person = getPersonById(id);
        person.setName(personNameDTO.getName());
        Person personSaved = personRepository.save(person);
        return new PersonDTO(personSaved);
    }

    @Override
    public PersonDTO updateCpf(Long id, PersonCpfDTO personCpfDTO) {
        Person person = getPersonById(id);
        person.setCpf(personCpfDTO.getCpf());
        Person personSaved = personRepository.save(person);
        return new PersonDTO(personSaved);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    Person getPersonById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public String getCpfById(Long id){
        String person = personRepository.findCpfById(id);
        return person;
    }


    @Override
    public PersonDTO createPerson(NewPersonDTO newPersonDTO) {
            Person person = new Person(newPersonDTO);
            Person personSaved = personRepository.save(person);
            return new PersonDTO(personSaved);
    }

    @Override
    public Boolean validateCPF(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            String url = "https://user-info.herokuapp.com/users/" + cpf;
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                System.out.println("CPF VÁLIDO");
                return true;
            } else if (response.getStatusCode().is4xxClientError() || response.getStatusCode().is5xxServerError()) {
                System.out.println("CPF INVÁLIDO");
            }
        }catch (Exception e){
            System.out.println("CPF INVÁLIDO: "+e);
            return false;
        }
        return false;
    }
}
