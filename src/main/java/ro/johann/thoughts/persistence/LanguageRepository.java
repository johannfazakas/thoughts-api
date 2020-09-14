package ro.johann.thoughts.persistence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import ro.johann.thoughts.model.Language;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Optional;

@Repository
@Slf4j
public class LanguageRepository {


    private final EntityManager entityManager;
    private final EntityTransaction transaction;

    public LanguageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
        this.transaction = entityManager.getTransaction();
    }

    public Language create(Language language) {
        log.info("create >> language = {}", language);
        transaction.begin();
        entityManager.persist(language);
        transaction.commit();
        return language;
    }

    public Optional<Language> get(String id) {
        log.info("get >> id = {}", id);
        return Optional.ofNullable(entityManager.find(Language.class, id));
    }
}
