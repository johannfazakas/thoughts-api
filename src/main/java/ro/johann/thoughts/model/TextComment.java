package ro.johann.thoughts.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class TextComment extends Comment {

    private String text;

    public TextComment(String text) {
        this.text = text;
    }
}
