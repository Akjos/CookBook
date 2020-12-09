package pl.akjos.CookBook.recipe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@Slf4j
@RequestMapping("/app/recipe")
public class RecipeController {

    @GetMapping("/add")
    public String prepareFormToAddRecipe(Model model) {
        log.debug("Go to add recipe page");
        model.addAttribute("recipe", new RecipeToSaveDTO());
        return "app/recipe/add";
    }

    @PostMapping("/add")
    public String addRecipe(@ModelAttribute("recipe") @Valid RecipeToSaveDTO recipe, BindingResult bindingResult, Model model) {
        log.debug("Add recipe to database {}", recipe);
        return "redirect:/app/recipe/add";
    }
}
