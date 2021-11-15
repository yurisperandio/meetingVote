package br.com.meetingVote.repository;

import br.com.meetingVote.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAll();

    @Query(value = "select i from Item i where i.id = :id")
    Item findItemById(Long id);

    @Query(value = "select i from Item i where i.subject like :subject")
    Item findItemBySubject(String subject);

}
