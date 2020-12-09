package pl.akjos.CookBook.recipe;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.akjos.CookBook.domain.model.Recipe;
import pl.akjos.CookBook.domain.model.User;
import pl.akjos.CookBook.domain.repositories.RecipeRepository;
import pl.akjos.CookBook.user.UserService;
import pl.akjos.CookBook.utils.SecurityUtils;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserService userService;

    @Override
    public void add(RecipeToSaveDTO recipeToSaveDTO) {
        String username = SecurityUtils.getUsername();
        User user = userService.getUserByName(username);
        Recipe recipe = Recipe.builder()
                .name(recipeToSaveDTO.getName())
                .description(recipeToSaveDTO.getDescription())
                .ingredients(recipeToSaveDTO.getIngredients())
                .preparationTime(recipeToSaveDTO.getPreparationTime())
                .preparation(recipeToSaveDTO.getPreparation())
                .user(user)
                .build();

        log.debug("Save recipe to database {}", recipe);

        recipeRepository.save(recipe);
    }
}
