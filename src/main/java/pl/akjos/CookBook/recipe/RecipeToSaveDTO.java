package pl.akjos.CookBook.recipe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipeToSaveDTO {

    private Long id;

    private String name;

    private String ingredients;

    private String description;

    private Integer preparationTime;

    private String preparation;
}
