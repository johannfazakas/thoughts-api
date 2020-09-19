package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ro.johann.thoughts.model.Thought;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Primary
public class ThoughtRepository {

    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    public ThoughtRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.transaction = entityManager.getTransaction();
    }

    public Thought save(Thought thought) {
        log.info("create >> thought = {}", thought);
        transaction.begin();
        entityManager.persist(thought);
        transaction.commit();
        return thought;
    }

    public Optional<Thought> get(String id) {
        log.info("get >> id = {}", id);
        return Optional.ofNullable(entityManager.find(Thought.class, id));
    }

    public List<Thought> list() {
        log.info("list >>");
        TypedQuery<Thought> query = entityManager.createNamedQuery("Thought_getAll", Thought.class);
        return query.getResultList();
    }
}
