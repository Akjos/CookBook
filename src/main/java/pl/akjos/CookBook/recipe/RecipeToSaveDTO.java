package pl.akjos.CookBook.recipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RecipeToSaveDTO {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String ingredients;

    @NotEmpty
    private String description;

    @NotNull
    @Min(1)
    private Integer preparationTime;

    @NotEmpty
    private String preparation;

    public RecipeToSaveDTO(Long id, @NotEmpty String name, @NotEmpty String ingredients, @NotEmpty String description, @NotNull @Min(1) Integer preparationTime, @NotEmpty String preparation) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.preparationTime = preparationTime;
        this.preparation = preparation;
    }

    public static RecipeToSaveDTOBuilder builder() {
        return new RecipeToSaveDTOBuilder();
    }

    public static class RecipeToSaveDTOBuilder {

        private Long id;
        private String name;
        private String ingredients;
        private String description;
        private Integer preparationTime;
        private String preparation;

        public RecipeToSaveDTOBuilder id (Long id) {
            this.id = id;
            return this;
        }

        public RecipeToSaveDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public RecipeToSaveDTOBuilder ingredients(String ingredients) {
            this.ingredients = ingredients;
            return this;
        }

        public RecipeToSaveDTOBuilder description(String description) {
            this.description = description;
            return this;
        }

        public RecipeToSaveDTOBuilder preparation(String preparation) {
            this.preparation = preparation;
            return this;
        }

        public RecipeToSaveDTOBuilder preparationTime(Integer preparationTime) {
            this.preparationTime = preparationTime;
            return this;
        }

        public RecipeToSaveDTO build() {
            return new RecipeToSaveDTO(id,name,ingredients,description,preparationTime,preparation);
        }
    }
}
