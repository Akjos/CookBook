package pl.akjos.CookBook.plan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akjos.CookBook.plan.dto.PlanToSaveDTO;
import pl.akjos.CookBook.utils.SecurityUtils;

import javax.validation.Valid;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/app/plan")
public class PlanController {

    private final PlanServiceImpl planService;

    @GetMapping
    public String showMainPlanPage() {
        log.debug("show main page of plan");
        return "redirect:/app/dashboard";
    }

    @GetMapping("/add")
    public String prepareFormToAddPlan(Model model) {
        model.addAttribute("plan", new PlanToSaveDTO());
        log.debug("Go prepare form to add plan");
        return "app/plan/add";
    }

    @PostMapping("/add")
    public String addPlan(@ModelAttribute("plan") @Valid PlanToSaveDTO planToSave, BindingResult bindingResult) {
        String username = SecurityUtils.getUsername();
        log.debug("Get plan:{} from for valid and pass to save for username: {}", planToSave, username);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "app/plan/add";
        }
        planService.add(planToSave, username);
        return "redirect:/app/plan";
    }
}
