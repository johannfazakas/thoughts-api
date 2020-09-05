package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Getter
@FieldDefaults(level = PRIVATE, makeFinal = true)
@ToString
@EqualsAndHashCode
public class ThoughtOutput {
    String id;
    String value;

    public ThoughtOutput(String id, String value) {
        this.id = id;
        this.value = value;
    }
}
