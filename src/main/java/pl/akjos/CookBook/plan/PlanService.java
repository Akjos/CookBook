package pl.akjos.CookBook.plan;

import pl.akjos.CookBook.plan.dto.PlanDTO;

import java.util.List;

public interface PlanService {

    void add(PlanDTO planToSave, String username);

    List<PlanDTO> getAllByPage(String username, Integer integer);

    Integer getNumberPages(String username);

}
