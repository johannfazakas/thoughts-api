package ro.johann.thoughts.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@ToString
@EqualsAndHashCode
@Slf4j
public class Thought {

    private final Integer id;
    private final String value;

    public Thought(Integer id, String value) {
        this.id = id;
        this.value = value;
    }

    public Thought(String value) {
        this.id = null;
        this.value = value;
    }

    public Thought withId(Integer id) {
        return new Thought(id, value);
    }
}