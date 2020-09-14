package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ro.johann.thoughts.model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;

@Repository
@Slf4j
public class TagRepository {

    private final EntityManager entityManager;
    private final EntityTransaction entityTransaction;

    public TagRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.entityTransaction = entityManager.getTransaction();
    }

    public Tag create(Tag tag) {
        log.info("create >> tag = {}", tag);
        entityTransaction.begin();
        entityManager.persist(tag);
        entityTransaction.commit();
        return tag;
    }

    public Optional<Tag> get(String id) {
        log.info("get >> id = {}", id);
        return Optional.ofNullable(entityManager.find(Tag.class, id));
    }
}
