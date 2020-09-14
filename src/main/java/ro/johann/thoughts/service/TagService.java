package ro.johann.thoughts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.johann.thoughts.model.Tag;
import ro.johann.thoughts.persistence.TagRepository;
import ro.johann.thoughts.transfer.TagCreateInput;

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
}
