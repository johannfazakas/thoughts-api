package ro.johann.thoughts.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.johann.thoughts.model.Comment;
import ro.johann.thoughts.model.Thought;
import ro.johann.thoughts.persistence.jpa.ThoughtRepository;
import ro.johann.thoughts.transfer.CommentCreateInput;
import ro.johann.thoughts.transfer.ThoughtCreateInput;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class ThoughtService {

    private final ThoughtRepository thoughtRepo;
    private final LanguageService languageService;
    private final TagService tagService;

    public ThoughtService(ThoughtRepository thoughtRepo, LanguageService languageService, TagService tagService) {
        this.thoughtRepo = thoughtRepo;
        this.languageService = languageService;
        this.tagService = tagService;
    }

    public Thought create(ThoughtCreateInput input) {
        log.info("create >> input = {}", input);

        var thought = new Thought();
        thought.setValue(input.getValue());
        thought.setLanguage(languageService.get(input.getLanguageId()));
        thought.setTags(tagService.list(input.getTagIds()));
        thought.setCreatedAt(LocalDateTime.now());
        return thoughtRepo.save(thought);
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

    public Comment addComment(String thoughtId, CommentCreateInput input) {
        log.info("addComment >> thoughtId = {}, input = {}", thoughtId, input);
        var comment = input.toModel();
        thoughtRepo.get(thoughtId)
                .map(t -> t.withComment(comment))
                .ifPresentOrElse(thoughtRepo::save, this::throwNotFound);
        return comment;
    }

    public void deleteComment(String thoughtId, String commentId) {
        log.info("deleteComment >> thoughtId = {}, commentId = {}", thoughtId, commentId);
        thoughtRepo.get(thoughtId)
                .map(t -> t.withoutComment(commentId))
                .ifPresentOrElse(thoughtRepo::save, this::throwNotFound);
    }

    private void throwNotFound() {
        throw new RuntimeException("Thought could not be found.");
    }
}
