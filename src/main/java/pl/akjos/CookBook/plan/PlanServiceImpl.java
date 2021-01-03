package pl.akjos.CookBook.plan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.stereotype.Service;
import pl.akjos.CookBook.domain.model.Plan;
import pl.akjos.CookBook.domain.model.User;
import pl.akjos.CookBook.domain.repositories.PlanRepository;
import pl.akjos.CookBook.domain.repositories.UserRepository;
import pl.akjos.CookBook.plan.dto.PlanToSaveDTO;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlanServiceImpl implements PlanService {

    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    @Override
    public void add(PlanToSaveDTO planToSave, String username) {
        User user = userRepository.getUserByUsername(username);
        Plan plan = Plan.builder()
                .name(planToSave.getName())
                .description(planToSave.getDescription())
                .build();
        plan.setUser(user);

        log.debug("Plan to save in database: {}",plan);
        planRepository.save(plan);
    }
}
