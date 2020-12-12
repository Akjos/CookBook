package pl.akjos.CookBook.recipe;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RecipeListDTO {

    private Long id;

    private String name;

    private String description;

    public RecipeListDTO(Long id, String name, String description) {

        this.id = id;
        this.name = name;
        this.description = description;
    }
}
