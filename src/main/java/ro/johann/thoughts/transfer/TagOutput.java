package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ro.johann.thoughts.model.Tag;

@Getter
@ToString
@EqualsAndHashCode
public class TagOutput {

    private final String id;
    private final String name;

    public TagOutput(Tag tag) {
        this.id = tag.getId();
        this.name = tag.getName();
    }
}
