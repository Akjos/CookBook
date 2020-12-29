package pl.akjos.CookBook.recipe;

import pl.akjos.CookBook.recipe.dto.RecipeDetailsDTO;
import pl.akjos.CookBook.recipe.dto.RecipeListDTO;
import pl.akjos.CookBook.recipe.dto.RecipeToSaveDTO;

import java.util.List;

public interface RecipeService {

    void add(RecipeToSaveDTO recipeToSaveDTO);

    List<RecipeListDTO> getAll(Integer page);

    Integer getNumberPages();

    RecipeDetailsDTO getRecipeByIdAndUsername(Long id, String username);
}
