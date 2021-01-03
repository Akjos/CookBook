package pl.akjos.CookBook.plan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akjos.CookBook.plan.dto.PlanToSaveDTO;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("app/plan")
public class PlanController {

    @GetMapping("/add")
    public String addPlan(Model model) {
        model.addAttribute("plan", new PlanToSaveDTO());
        log.debug("Go prepare form to add plan");
        return "app/plan/add";
    }
}
