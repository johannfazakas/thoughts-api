package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;
import ro.johann.thoughts.model.Thought;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class ThoughtJPARepository implements ThoughtRepository {

    @Override
    public Thought create(Thought thought) {
        throw new RuntimeException("not implemented.");
    }

    @Override
    public Optional<Thought> get(Integer id) {
        throw new RuntimeException("not implemented.");
    }

    @Override
    public List<Thought> list() {
        throw new RuntimeException("not implemented.");
    }
}
