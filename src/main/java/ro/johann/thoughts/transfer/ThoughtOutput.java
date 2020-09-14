package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ro.johann.thoughts.model.Thought;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
public class ThoughtOutput {
    private final Long id;
    private final String value;
    private final LocalDateTime createdAt;

    public ThoughtOutput(Thought thought) {
        this.id = thought.getId();
        this.value = thought.getValue();
        this.createdAt = thought.getCreatedAt();
    }

}

