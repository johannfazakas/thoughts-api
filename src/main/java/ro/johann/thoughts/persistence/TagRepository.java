package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ro.johann.thoughts.model.Tag;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Slf4j
public class TagRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Tag create(Tag tag) {
        log.info("create >> tag = {}", tag);
        entityManager.persist(tag);
        return tag;
    }

    public Optional<Tag> get(String id) {
        log.info("get >> id = {}", id);
        return Optional.ofNullable(entityManager.find(Tag.class, id));
    }
}
