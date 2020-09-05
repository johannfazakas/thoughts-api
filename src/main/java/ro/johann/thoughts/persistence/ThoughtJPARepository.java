package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;
import ro.johann.thoughts.model.Thought;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@Primary
public class ThoughtJPARepository implements ThoughtRepository {

    private final EntityManager entityManager;

    public ThoughtJPARepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Thought create(Thought thought) {
        entityManager.persist(thought);
        return thought;
//        throw new RuntimeException("not implemented.");
    }

    @Override
    public Optional<Thought> get(Integer id) {
        return Optional.ofNullable(entityManager.find(Thought.class, id));
//        throw new RuntimeException("not implemented.");
    }

    @Override
    public List<Thought> list() {
        throw new RuntimeException("not implemented.");
    }
}
