package ro.johann.thoughts.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "thought")
public class Thought {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    private String value;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Thought(String id, String value, LocalDateTime createdAt) {
        this.id = id;
        this.value = value;
        this.createdAt = createdAt;
    }

    public Thought(String value, LocalDateTime createdAt) {
        this.value = value;
        this.createdAt = createdAt;
    }
}