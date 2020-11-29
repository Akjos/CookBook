package pl.akjos.CookBook.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akjos.CookBook.domain.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
