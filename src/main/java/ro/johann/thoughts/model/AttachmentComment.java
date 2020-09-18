package ro.johann.thoughts.model;

import lombok.*;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class AttachmentComment extends Comment {

    private String attachment;

    public AttachmentComment(String attachment) {
        this.attachment = attachment;
    }
}
