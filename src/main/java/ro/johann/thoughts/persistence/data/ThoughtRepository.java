package ro.johann.thoughts.persistence.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.johann.thoughts.model.Thought;

public interface ThoughtRepository extends JpaRepository<Thought, String> {
}
