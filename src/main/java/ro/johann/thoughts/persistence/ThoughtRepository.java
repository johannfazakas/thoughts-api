package ro.johann.thoughts.persistence;

import ro.johann.thoughts.model.Thought;

import java.util.List;
import java.util.Optional;

public interface ThoughtRepository {
    Thought create(Thought thought);
    Optional<Thought> get(Long id);
    List<Thought> list();
}
