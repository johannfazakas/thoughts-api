package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

import static lombok.AccessLevel.PRIVATE;
import static java.util.Optional.ofNullable;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@ToString
@EqualsAndHashCode
public class ThoughtOutput {
    @Getter
    String id;
    String value;

    public ThoughtOutput(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public ThoughtOutput(String id) {
        this.id = id;
        this.value = null;
    }

    public Optional<String> getValue() {
        return ofNullable(value);
    }
}

