package pl.akjos.CookBook.recipe;

import java.util.List;

public interface RecipeService {

    void add(RecipeToSaveDTO recipeToSaveDTO);

    List<RecipeListDTO> getAll();
}
