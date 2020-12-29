package pl.akjos.CookBook.recipe.dto;

import lombok.Data;

@Data
public class RecipeDetailsDTO {

    private String name;

    private String ingredients;

    private String description;

    private Integer preparationTime;

    private String preparation;

    public RecipeDetailsDTO(String name, String ingredients, String description, Integer preparationTime, String preparation) {
        this.name = name;
        this.ingredients = ingredients;
        this.description = description;
        this.preparationTime = preparationTime;
        this.preparation = preparation;
    }
}
