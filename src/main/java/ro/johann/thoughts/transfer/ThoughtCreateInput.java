package ro.johann.thoughts.transfer;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Optional;

import static java.util.Optional.ofNullable;

import static lombok.AccessLevel.PRIVATE;

@FieldDefaults(level = PRIVATE, makeFinal = true)
@ToString
@EqualsAndHashCode
public class ThoughtCreateInput {

    String value;

    @JsonCreator
    public ThoughtCreateInput(String value) {
        this.value = value;
    }

    public Optional<String> getValue() {
        return ofNullable(value);
    }
}
