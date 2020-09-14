package ro.johann.thoughts.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.AUTO;

@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "thought")
public class Thought {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String value;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Thought(Long id, String value, LocalDateTime createdAt) {
        this.id = id;
        this.value = value;
        this.createdAt = createdAt;
    }

    public Thought(String value, LocalDateTime createdAt) {
        this.value = value;
        this.createdAt = createdAt;
    }
}