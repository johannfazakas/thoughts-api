package ro.johann.thoughts.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
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
@Builder
@ToString
@EqualsAndHashCode
public class Thought {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @Column(length = 36)
    private String id;
    @Column(length = 5000, nullable = false)
    private String value;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @ManyToOne
    private Language language;
    @ManyToMany
    @JoinTable(name = "thought_tag",
            joinColumns = @JoinColumn(name = "thought_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
    @OneToMany(cascade = ALL, fetch = EAGER,  orphanRemoval = true)
    @JoinColumn(name = "thought_id")
    @Builder.Default
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