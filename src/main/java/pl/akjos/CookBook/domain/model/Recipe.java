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

    public Recipe(Long id, String name, String ingredients, String description, Integer preparationTime, String preparation, User user) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.preparationTime = preparationTime;
        this.preparation = preparation;
        this.user = user;
    }

    public static RecipeBuilder builder() {
        return new RecipeBuilder();
    }

    @PrePersist
    public void prePersist() {
        this.created = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.update = LocalDate.now();
    }

    public static class RecipeBuilder {
        private Long id;
        private String name;
        private String ingredients;
        private String description;
        private Integer preparationTime;
        private String preparation;
        private User user;

        RecipeBuilder() {
        }

        public RecipeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public RecipeBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RecipeBuilder ingredients(String ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public RecipeBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RecipeBuilder preparationTime(Integer preparationTime) {
            this.preparationTime = preparationTime;
            return this;
        }

        public RecipeBuilder preparation(String preparation) {
            this.preparation = preparation;
            return this;
        }

        public RecipeBuilder user(User user) {
            this.user = user;
            return this;
        }

        public Recipe build() {
            return new Recipe(id, name, ingredients, description, preparationTime, preparation, user);
        }

        public String toString() {
            return "Recipe.RecipeBuilder(id=" + this.id + ", name=" + this.name + ", ingredients=" + this.ingredients + ", description=" + this.description +  ", preparationTime=" + this.preparationTime + ", preparation=" + this.preparation + ", user=" + this.user + ")";
        }
    }
}
