package pl.akjos.CookBook.domain.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "plans")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 80, nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    @Column
    private LocalDate created;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @PrePersist
    public void prePersist() {
        this.created = LocalDate.now();
    }
}
