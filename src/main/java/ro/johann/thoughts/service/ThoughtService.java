package ro.johann.thoughts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.johann.thoughts.persistence.ThoughtRepository;
import ro.johann.thoughts.transfer.ThoughtCreateInput;
import ro.johann.thoughts.transfer.ThoughtOutput;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@Slf4j
public class ThoughtService {

    private final ThoughtRepository thoughtRepo;

    public ThoughtService(ThoughtRepository thoughtRepo) {
        this.thoughtRepo = thoughtRepo;
    }

    public ThoughtOutput create(ThoughtCreateInput input) {
        log.info("create >> input = {}", input);
        return new ThoughtOutput(thoughtRepo.create(input.toModel()));
    }

    public ThoughtOutput get(String id) {
        log.info("get >> input = {}", id);
        return thoughtRepo.get(id)
                .map(ThoughtOutput::new)
                .orElseThrow(() -> new RuntimeException("Thought not found"));
    }

    public List<ThoughtOutput> list() {
        log.info("list >>");
        return thoughtRepo.list().stream()
                .map(ThoughtOutput::new)
                .collect(toList());
    }
}
