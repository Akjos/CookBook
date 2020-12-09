package pl.akjos.CookBook.recipe;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/app/recipe")
public class RecipeController {

    @GetMapping("/add")
    public String prepareFormToAddRecipe(Model model) {
        model.addAttribute("recipe", new RecipeToSaveDTO());
        return "app/recipe/add";
    }
}
