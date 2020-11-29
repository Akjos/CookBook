package pl.akjos.CookBook.domain.model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"recipe_id", "plan_id"}), name = "recipe_plan")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RecipePlan {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "meal_name", length = 50, nullable = false)
    private String mealName;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder;

    @JoinColumn(name = "recipe_id", insertable = false, updatable = false)
    @ManyToOne
    private Recipe recipe;

    @Column(name = "recipe_id")
    private Long recipeId;

    @JoinColumn(name = "plan_id", insertable = false, updatable = false)
    @ManyToOne
    private Plan plan;

    @Column(name = "plan_id")
    private Long planId;

    @JoinColumn(name = "day_id")
    @ManyToOne
    private Day day;

}
