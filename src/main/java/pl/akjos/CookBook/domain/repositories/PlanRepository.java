package pl.akjos.CookBook.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akjos.CookBook.domain.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}
