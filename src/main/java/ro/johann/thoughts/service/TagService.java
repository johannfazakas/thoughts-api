package ro.johann.thoughts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.johann.thoughts.model.Tag;
import ro.johann.thoughts.persistence.jpa.TagRepository;
import ro.johann.thoughts.transfer.TagCreateInput;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Service
@Slf4j
public class TagService {

    private final TagRepository tagRepo;

    public TagService(TagRepository tagRepo) {
        this.tagRepo = tagRepo;
    }

    public Tag create(TagCreateInput input) {
        log.info("create >> input = {}", input);
        return tagRepo.create(input.toModel());
    }

    public Tag get(String id) {
        log.info("get >> id = {}", id);
        return tagRepo.get(id).orElseThrow(() -> new RuntimeException("Tag not found."));
    }

    public Set<Tag> list(Set<String> ids) {
        log.info("list >> ids = {}", ids);
        if (ids.isEmpty()) {
            return Set.of();
        }
        // TODO implement with single call
        return ids.stream()
                .map(this::get)
                .collect(toSet());
    }
}
