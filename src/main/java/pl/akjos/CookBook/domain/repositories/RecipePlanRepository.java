package pl.akjos.CookBook.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akjos.CookBook.domain.model.RecipePlan;

public interface RecipePlanRepository extends JpaRepository<RecipePlan, Long> {
}
