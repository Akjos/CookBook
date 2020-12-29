package pl.akjos.CookBook.recipe.DTO;

import lombok.Data;

@Data
public class RecipeDetailsDTO {

    private String name;

    private String ingredients;

    private String description;

    private Integer preparationTime;

    private String preparation;
}
