package ro.johann.thoughts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.johann.thoughts.model.Language;
import ro.johann.thoughts.persistence.jpa.LanguageRepository;
import ro.johann.thoughts.transfer.LanguageCreateInput;

@Service
@Slf4j
public class LanguageService {

    private final LanguageRepository languageRepo;

    public LanguageService(LanguageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }

    public Language create(LanguageCreateInput input) {
        log.info("create >> input = {}", input);
        return languageRepo.create(input.toModel());
    }

    public Language get(String id) {
        log.info("get >> id = {}", id);
        return languageRepo.get(id)
                .orElseThrow(() -> new RuntimeException("Language not found"));
    }
}
