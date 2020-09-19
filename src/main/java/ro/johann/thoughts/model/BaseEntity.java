package ro.johann.thoughts.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Slf4j
public abstract class BaseEntity {

    @Id
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @Column(length = 36)
    private String id;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "last_modified_on")
    private LocalDateTime lastModifiedOn;

    @PrePersist
    protected void prePersist() {
        log.info("prePersist >> {}", this);
        var now = LocalDateTime.now();
        createdAt = now;
        lastModifiedOn = now;
    }

    @PreUpdate
    protected void preUpdate() {
        log.info("preUpdate >> {}", this);
        lastModifiedOn = LocalDateTime.now();
    }

    @PreRemove
    protected void preRemove() {
        log.info("preRemove >> {}", this);
    }

    @PostPersist
    protected void postPersist() {
        log.info("postPersist >> {}", this);
    }

    @PostUpdate
    protected void postUpdate() {
        log.info("postUpdate >> {}", this);
    }

    @PostRemove
    protected void postRemove() {
        log.info("postRemove >> {}", this);
    }

    @PostLoad
    protected void postLoad() {
        log.info("postLoad >> {}", this);
    }
}
