package ro.johann.thoughts.persistence;

import ro.johann.thoughts.model.Thought;

import java.util.List;
import java.util.Optional;

public interface ThoughtRepository {
    Thought save(Thought thought);
    Optional<Thought> get(String id);
    List<Thought> list();
}
