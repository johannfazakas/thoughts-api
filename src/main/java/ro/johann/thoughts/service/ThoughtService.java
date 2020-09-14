package ro.johann.thoughts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.johann.thoughts.model.Thought;
import ro.johann.thoughts.persistence.ThoughtRepository;
import ro.johann.thoughts.transfer.ThoughtCreateInput;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ThoughtService {

    private final ThoughtRepository thoughtRepo;
    private final LanguageService languageService;

    public ThoughtService(ThoughtRepository thoughtRepo, LanguageService languageService) {
        this.thoughtRepo = thoughtRepo;
        this.languageService = languageService;
    }

    public Thought create(ThoughtCreateInput input) {
        log.info("create >> input = {}", input);

        Thought thought = Thought.builder()
                .value(input.getValue())
                .language(languageService.get(input.getLanguageId()))
                .createdAt(LocalDateTime.now())
                .build();
        return thoughtRepo.create(thought);
    }

    public Thought get(String id) {
        log.info("get >> input = {}", id);
        return thoughtRepo.get(id)
                .orElseThrow(() -> new RuntimeException("Thought not found"));
    }

    public List<Thought> list() {
        log.info("list >>");
        return thoughtRepo.list();
    }
}
