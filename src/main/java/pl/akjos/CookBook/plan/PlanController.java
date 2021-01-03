package pl.akjos.CookBook.plan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.akjos.CookBook.plan.dto.PlanDTO;
import pl.akjos.CookBook.recipe.dto.RecipeListDTO;
import pl.akjos.CookBook.utils.SecurityUtils;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/app/plan")
public class PlanController {

    private final PlanServiceImpl planService;



    @GetMapping(value = {"", "/{page}"})
    public String showMainRecipePage(@PathVariable(name = "page") Optional<Integer> pageVariable, Model model) {
        String username = SecurityUtils.getUsername();
        log.debug("Go to page list, page nr {} for username: {}", pageVariable, username);
        Integer page = pageVariable.orElse(0);
        Integer maxPagesNum = planService.getNumberPages(username);
        if(page > maxPagesNum) {
            page = maxPagesNum;
        }
        List<PlanDTO> planDTOList = planService.getAllByPage(username, page);
        model.addAttribute("planList", planDTOList);
        model.addAttribute("page", page);
        model.addAttribute("maxPages", maxPagesNum);
        return "app/plan/list";
    }

    @GetMapping("/add")
    public String prepareFormToAddPlan(Model model) {
        model.addAttribute("plan", new PlanDTO());
        log.debug("Go prepare form to add plan");
        return "app/plan/add";
    }

    @PostMapping("/add")
    public String addPlan(@ModelAttribute("plan") @Valid PlanDTO planToSave, BindingResult bindingResult) {
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
