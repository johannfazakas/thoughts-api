package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ro.johann.thoughts.model.Thought;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Getter
@ToString
@EqualsAndHashCode
public class ThoughtOutput {

    private final String id;
    private final String value;
    private final LocalDateTime createdAt;
    private final LanguageOutput language;
    private final List<TagOutput> tags;
    private final List<CommentOutput> comments;

    public ThoughtOutput(Thought thought) {
        this.id = thought.getId();
        this.value = thought.getValue();
        this.createdAt = thought.getCreatedAt();
        this.language = new LanguageOutput(thought.getLanguage());
        this.tags = thought.getTags().stream()
                .map(TagOutput::new)
                .collect(Collectors.toList());
        this.comments = thought.getComments().stream()
                .map(CommentOutput::new)
                .collect(toList());
    }

}

