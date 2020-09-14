package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.johann.thoughts.model.Tag;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class TagCreateInput {

    private String name;

    public Tag toModel() {
        return new Tag(name);
    }
}
