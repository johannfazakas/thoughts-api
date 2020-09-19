package ro.johann.thoughts.persistence.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ro.johann.thoughts.model.Thought;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
public class ThoughtRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Thought save(Thought thought) {
        log.info("create >> thought = {}", thought);
        entityManager.persist(thought);
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
