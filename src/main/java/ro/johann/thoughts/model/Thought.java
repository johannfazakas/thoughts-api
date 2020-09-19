package ro.johann.thoughts.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Table(name = "thought")
@NamedQueries({
        @NamedQuery(name = "Thought_getAll", query = "select t from Thought t")
})
@NoArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Thought extends BaseEntity {

    @Column(length = 5000, nullable = false)
    private String value;
    @ManyToOne
    private Language language;
    @ManyToMany
    @JoinTable(name = "thought_tag",
            joinColumns = @JoinColumn(name = "thought_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
    @OneToMany(cascade = ALL, fetch = EAGER,  orphanRemoval = true)
    @JoinColumn(name = "thought_id")
    private Set<Comment> comments = new HashSet<>();

    public Thought withComment(Comment comment) {
        comments.add(comment);
        return this;
    }

    public Thought withoutComment(String commentId) {
        comments.removeIf(c -> commentId.equals(c.getId()));
        return this;
    }
}