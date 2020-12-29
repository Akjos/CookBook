package pl.akjos.CookBook.domain.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.akjos.CookBook.domain.model.Recipe;
import pl.akjos.CookBook.recipe.dto.RecipeDetailsDTO;
import pl.akjos.CookBook.recipe.dto.RecipeListDTO;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT new pl.akjos.CookBook.recipe.dto.RecipeListDTO(r.id, r.name, r.description) FROM Recipe r JOIN r.user u WHERE u.id = :userId")
    List<RecipeListDTO> getRecipesByUserId(Long userId, Pageable pageable);

    @Query("SELECT new pl.akjos.CookBook.recipe.dto.RecipeDetailsDTO(r.name, r.ingredients, r.description, r.preparationTime, r.preparation) FROM Recipe r JOIN r.user u WHERE r.id = :recipeId AND u.username = :username")
    Optional<RecipeDetailsDTO> findRecipeByIdAndUserId(Long recipeId, String username);

    Integer countByUserId(Long id);
}
