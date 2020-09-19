package ro.johann.thoughts.persistence.data;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.johann.thoughts.model.Language;

public interface LanguageRepository extends JpaRepository<Language, String> {
}
