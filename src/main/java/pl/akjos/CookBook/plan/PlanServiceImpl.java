package pl.akjos.CookBook.plan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.akjos.CookBook.domain.model.Plan;
import pl.akjos.CookBook.domain.model.User;
import pl.akjos.CookBook.domain.repositories.PlanRepository;
import pl.akjos.CookBook.domain.repositories.UserRepository;
import pl.akjos.CookBook.plan.dto.PlanDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PlanServiceImpl implements PlanService {

    private final static Integer QUANTITY_ELEMENT_ON_PAGE = 2;

    private final UserRepository userRepository;
    private final PlanRepository planRepository;

    @Override
    public void add(PlanDTO planToSave, String username) {
        User user = userRepository.getUserByUsername(username);
        Plan plan = Plan.builder()
                .name(planToSave.getName())
                .description(planToSave.getDescription())
                .build();
        plan.setUser(user);

        log.debug("Plan to save in database: {}",plan);
        planRepository.save(plan);
    }

    @Override
    public List<PlanDTO> getAllByPage(String username, Integer page) {
        Pageable pageable = PageRequest.of(page, QUANTITY_ELEMENT_ON_PAGE);

        log.debug("Get recipe list size = {}, page = {} by username = {} from database", QUANTITY_ELEMENT_ON_PAGE, page, username);

        List<PlanDTO> planList = planRepository.getAllByUsernameAndPageable(username, pageable);

        return planList;
    }

    @Override
    public Integer getNumberPages(String username) {
        Integer countPlan = planRepository.countPlanByUserName(username);
        Integer page = (countPlan - 1) / QUANTITY_ELEMENT_ON_PAGE;
        log.debug("Number recipe: {} Number page: {} for username: {}", countPlan, page, username);
        return (page > 0) ? page : 0;
    }
}
