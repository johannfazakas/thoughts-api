package ro.johann.thoughts.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ro.johann.thoughts.model.Comment;
import ro.johann.thoughts.service.ThoughtService;
import ro.johann.thoughts.transfer.CommentCreateInput;
import ro.johann.thoughts.transfer.CommentOutput;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/thoughts-api/v1/thoughts/{thoughtId}/comments")
@Slf4j
public class CommentController {

    private final ThoughtService thoughtService;

    public CommentController(ThoughtService thoughtService) {
        this.thoughtService = thoughtService;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public CommentOutput addComment(@PathVariable("thoughtId") String thoughtId, @RequestBody CommentCreateInput input) {
        log.info("addComment >> thoughtId = {}, input = {}", thoughtId, input);
        Comment comment = thoughtService.addComment(thoughtId, input);
        return new CommentOutput(comment);
    }

    @DeleteMapping("/{commentId}")
    @ResponseStatus(NO_CONTENT)
    public void deleteComment(@PathVariable("thoughtId") String thoughtId, @PathVariable("commentId") String commentId) {
        log.info("deleteComment >> thoughtId = {}, commentId = {}", thoughtId, commentId);
        thoughtService.deleteComment(thoughtId, commentId);
    }
}
