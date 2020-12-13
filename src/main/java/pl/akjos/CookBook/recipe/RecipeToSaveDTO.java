package pl.akjos.CookBook.recipe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
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
}
