package ro.johann.thoughts.transfer;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@ToString
@EqualsAndHashCode
public class ThoughtCreateInput {
    String value;

    public ThoughtCreateInput(String value) {
        this.value = value;
    }
}
