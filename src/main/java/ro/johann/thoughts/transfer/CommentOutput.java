package ro.johann.thoughts.transfer;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import ro.johann.thoughts.model.AttachmentComment;
import ro.johann.thoughts.model.Comment;
import ro.johann.thoughts.model.TextComment;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
@Getter
@ToString
@EqualsAndHashCode
public class CommentOutput {

    private String id;
    private String text;
    private String attachment;

    public CommentOutput(Comment comment) {
        this.id = comment.getId();
        // TODO refactor this instanceof mess
        if (comment instanceof TextComment) {
            this.text = ((TextComment) comment).getText();
        }
        if (comment instanceof AttachmentComment) {
            this.attachment = ((AttachmentComment) comment).getAttachment();
        }
    }
}
