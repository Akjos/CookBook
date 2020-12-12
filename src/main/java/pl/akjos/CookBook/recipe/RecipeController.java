package pl.akjos.CookBook.recipe;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/app/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping(value = {"", "/{page}"})
    public String showMainRecipePage(@PathVariable(name = "page") Optional<Integer> pageVariable, Model model) {
        log.debug("Go to page list, page nr {}", pageVariable);
        Integer page = pageVariable.orElse(0);
        Integer maxPagesNum = recipeService.getNumberPages();
        if(page > maxPagesNum) {
            page = maxPagesNum;
        }
        List<RecipeListDTO> recipesDTO = recipeService.getAll(page);
        model.addAttribute("recipesList", recipesDTO);
        model.addAttribute("page", page);
        model.addAttribute("maxPages", maxPagesNum);
        return "app/recipe/list";
    }

    @GetMapping("/add")
    public String prepareFormToAddRecipe(Model model) {
        log.debug("Go to add recipe page");
        model.addAttribute("recipe", new RecipeToSaveDTO());
        return "app/recipe/add";
    }

    @PostMapping("/add")
    public String addRecipe(@ModelAttribute("recipe") @Valid RecipeToSaveDTO recipe, BindingResult bindingResult, Model model) {
        log.debug("Add recipe to database {}", recipe);
        if (bindingResult.hasErrors()) {
            return "/app/recipe/add";
        }
        recipeService.add(recipe);
        return "redirect:/app/recipe";
    }
}
