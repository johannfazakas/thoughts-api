package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ro.johann.thoughts.model.Thought;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Primary
public class ThoughtJPARepository implements ThoughtRepository {

    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    public ThoughtJPARepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.transaction = entityManager.getTransaction();
    }

    @Override
    public Thought create(Thought thought) {
        transaction.begin();
        entityManager.persist(thought);
        transaction.commit();
        return thought;
    }

    @Override
    public Optional<Thought> get(Long id) {
        return Optional.ofNullable(entityManager.find(Thought.class, id));
    }

    @Override
    public List<Thought> list() {
        throw new RuntimeException("not implemented.");
    }
}
