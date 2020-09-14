package ro.johann.thoughts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.johann.thoughts.persistence.LanguageRepository;
import ro.johann.thoughts.transfer.LanguageCreateInput;
import ro.johann.thoughts.transfer.LanguageOutput;

@Service
@Slf4j
public class LanguageService {

    private final LanguageRepository languageRepo;

    public LanguageService(LanguageRepository languageRepo) {
        this.languageRepo = languageRepo;
    }

    public LanguageOutput create(LanguageCreateInput input) {
        log.info("create >> input = {}", input);
        return new LanguageOutput(languageRepo.create(input.toModel()));
    }

    public LanguageOutput get(String id) {
        log.info("get >> id = {}", id);
        return languageRepo.get(id)
                .map(LanguageOutput::new)
                .orElseThrow(() -> new RuntimeException("Language not found"));
    }
}
