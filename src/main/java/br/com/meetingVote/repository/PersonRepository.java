package br.com.meetingVote.repository;

import br.com.meetingVote.model.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    @Override
    List<Person> findAll();

    @Query(value = "select p from Person p where p.cpf = :cpf")
    Person findPersonByCpf(String cpf);

    @Query(value = "select p from Person p where p.name like :name")
    Person findPersonByName(String name);

    @Query(value = "select p from Person p where p.id = :id")
    Person findPersonById(Long id);

    @Query(value = "select p.cpf from Person p where p.id = :id")
    String findCpfById(Long id);

}
