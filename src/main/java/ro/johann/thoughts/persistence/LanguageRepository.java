package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ro.johann.thoughts.model.Language;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Slf4j
public class LanguageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Language create(Language language) {
        log.info("create >> language = {}", language);
        entityManager.persist(language);
        return language;
    }

    public Optional<Language> get(String id) {
        log.info("get >> id = {}", id);
        return Optional.ofNullable(entityManager.find(Language.class, id));
    }
}
