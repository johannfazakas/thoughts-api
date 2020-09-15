package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ThoughtCreateInput {

    private String value;
    private String languageId;
    private Set<String> tagIds = Set.of();
}
