package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ro.johann.thoughts.model.Thought;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;
import static java.util.Optional.ofNullable;

@Getter
@ToString
@EqualsAndHashCode
public class ThoughtOutput {
    private final Long id;
    private final String value;

    public ThoughtOutput(Thought thought) {
        this.id = thought.getId();
        this.value = thought.getValue();
    }

}

