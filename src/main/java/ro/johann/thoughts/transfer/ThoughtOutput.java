package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import ro.johann.thoughts.model.Thought;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;
import static java.util.Optional.ofNullable;

@ToString
@EqualsAndHashCode
public class ThoughtOutput {
    @Getter
    private final Integer id;
    private final String value;

    public ThoughtOutput(Thought thought) {
        this.id = thought.getId();
        this.value = thought.getValue();
    }

    public ThoughtOutput(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Optional<String> getValue() {
        return ofNullable(value);
    }
}

