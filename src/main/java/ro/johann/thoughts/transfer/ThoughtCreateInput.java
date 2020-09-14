package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.johann.thoughts.model.Thought;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ThoughtCreateInput {

    private String value;

    public Thought toModel() {
        return new Thought(value, LocalDateTime.now());
    }
}
