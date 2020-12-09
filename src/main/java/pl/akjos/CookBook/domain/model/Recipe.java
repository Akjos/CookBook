package pl.akjos.CookBook.domain.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "recipes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 500, nullable = false)
    private String ingredients;

    @Column(length = 700, nullable = false)
    private String description;

    @Column
    private LocalDate created;

    @Column
    private LocalDate update;

    @Column(name = "preparation_time", nullable = false)
    private Integer preparationTime;

    @Column(length = 700, nullable = false)
    private String preparation;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @PrePersist
    public void prePersist() {
        this.created = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.update = LocalDate.now();
    }
}
