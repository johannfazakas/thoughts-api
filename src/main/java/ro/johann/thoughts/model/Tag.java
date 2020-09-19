package ro.johann.thoughts.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "tag")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Tag extends BaseEntity {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @Column(length = 36)
    private String id;
    @Column(length = 55)
    private String name;

    public Tag(String name) {
        this.name = name;
    }
}
