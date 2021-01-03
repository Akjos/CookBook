package pl.akjos.CookBook.domain.repositories;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.akjos.CookBook.domain.model.Plan;
import pl.akjos.CookBook.plan.dto.PlanDTO;

import java.util.List;

public interface PlanRepository extends JpaRepository<Plan, Long> {

    @Query("SELECT COUNT (p) FROM Plan p JOIN p.user u WHERE u.username = :username")
    Integer countPlanByUserName(String username);

    @Query("SELECT new pl.akjos.CookBook.plan.dto.PlanDTO(p.id, p.name, p.description) FROM Plan p JOIN p.user u WHERE u.username = :username")
    List<PlanDTO> getAllByUsernameAndPageable(String username, Pageable pageable);
}
