package ro.johann.thoughts.transfer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.johann.thoughts.model.AttachmentComment;
import ro.johann.thoughts.model.Comment;
import ro.johann.thoughts.model.TextComment;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CommentCreateInput {
    private String type;
    private String text;
    private String attachment;

    public Comment toModel() {
        switch (type) {
            case "text": return new TextComment(text);
            case "attachment": return new AttachmentComment(attachment);
            // TODO refactor to eliminate switch
            default: throw new RuntimeException("Comment type not allowed.");
        }
    }
}
