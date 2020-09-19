package ro.johann.thoughts.persistence.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.johann.thoughts.model.Tag;

public interface TagRepository extends JpaRepository<Tag, String> {
}
