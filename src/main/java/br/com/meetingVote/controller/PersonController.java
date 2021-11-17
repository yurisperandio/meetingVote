package br.com.meetingVote.controller;

import br.com.meetingVote.dto.NewPersonDTO;
import br.com.meetingVote.dto.PersonCpfDTO;
import br.com.meetingVote.dto.PersonDTO;
import br.com.meetingVote.dto.PersonNameDTO;
import br.com.meetingVote.model.Person;
import br.com.meetingVote.repository.PersonRepository;
import br.com.meetingVote.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@Api(value = "API Person")
public class PersonController {

    PersonService personService;
    PersonRepository personRepository;

    public PersonController(PersonService personService, PersonRepository personRepository) {
        this.personService = personService;
        this.personRepository = personRepository;
    }

    @GetMapping("/")
    @ApiOperation(value = "Retorna todas pessoas cadastrados")
    public List<PersonDTO> getAllPerson() {
        return personService.getPerson();
    }

    @GetMapping("id/{id}")
    @ApiOperation(value = "Retorna pessoa por ID")
    public Person getPersonById(@PathVariable Long id) {
        return personRepository.findPersonById(id);
    }

    @GetMapping("cpf/{cpf}")
    @ApiOperation(value = "Retorna pessoa por CPF")
    public PersonDTO getPersonByCpf(@PathVariable String cpf) {
        return personService.getPersonByCpf(cpf);
    }

    @GetMapping("name/{name}")
    @ApiOperation(value = "Retorna pessoa por nome")
    public PersonDTO getPersonByName(@PathVariable String name) {
        return personService.getPersonByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Cria uma nova pessoa")
    public ResponseEntity<PersonDTO> createPerson(@RequestBody NewPersonDTO newPersonDTO) {
        if (!personService.validateCPF(newPersonDTO.getCpf())) {
            return new ResponseEntity<PersonDTO>(HttpStatus.NOT_ACCEPTABLE);
        }
        PersonDTO personDTO = personService.createPerson(newPersonDTO);
        return new ResponseEntity<PersonDTO>(personDTO, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Atualiza o nome da pessoa")
    private PersonDTO updatePersonName(@PathVariable Long id, @RequestBody PersonNameDTO personNameDTO) {
        return personService.updateName(id, personNameDTO);
    }

    @PatchMapping("{id}")
    @ApiOperation(value = "Atualiza o CPF da pessoa")
    private PersonDTO updatePersonCpf(@PathVariable Long id, @RequestBody PersonCpfDTO personCpfDTO) {
        return personService.updateCpf(id, personCpfDTO);
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Deleta a pessoa, filtrando pelo ID")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }


}
