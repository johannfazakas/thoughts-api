package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ThoughtCreateInput {

    private String value;
    private String languageId;
}
