package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ro.johann.thoughts.model.Thought;

import java.time.LocalDateTime;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Getter
@ToString
@EqualsAndHashCode
public class ThoughtOutput {

    private final String id;
    private final String value;
    private final LocalDateTime createdAt;
    private final LanguageOutput language;
    private final Set<TagOutput> tags;

    public ThoughtOutput(Thought thought) {
        this.id = thought.getId();
        this.value = thought.getValue();
        this.createdAt = thought.getCreatedAt();
        this.language = new LanguageOutput(thought.getLanguage());
        this.tags = thought.getTags().stream()
                .map(TagOutput::new)
                .collect(toSet());
    }

}

