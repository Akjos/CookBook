package pl.akjos.CookBook.domain.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.akjos.CookBook.domain.model.Recipe;
import pl.akjos.CookBook.recipe.DTO.RecipeListDTO;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT new pl.akjos.CookBook.recipe.DTO.RecipeListDTO(r.id, r.name, r.description) FROM Recipe r JOIN r.user u WHERE u.id = :userId")
    List<RecipeListDTO> getRecipesByUserId(Long userId, Pageable pageable);

    Integer countByUserId(Long id);
}
