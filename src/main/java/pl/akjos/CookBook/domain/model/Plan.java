package pl.akjos.CookBook.domain.model;


import lombok.*;
import org.hibernate.loader.plan.build.spi.MetamodelDrivenLoadPlanBuilder;

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

    private Plan(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @PrePersist
    public void prePersist() {
        this.created = LocalDate.now();
    }

    public static PlanBuilder builder() {
        return new PlanBuilder();
    }

    public static class PlanBuilder {
        private Long id;
        private String name;
        private String description;

        PlanBuilder() {
        }

        public PlanBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public PlanBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PlanBuilder description(String description) {
            this.description = description;
            return this;
        }

        public Plan build() {
            return new Plan(id, name, description);
        }
    }
}
