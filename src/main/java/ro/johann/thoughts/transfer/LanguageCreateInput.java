package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.johann.thoughts.model.Language;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LanguageCreateInput {

    private String name;

    public Language toModel() {
        return new Language(name);
    }
}
