package pl.akjos.CookBook.recipe;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.akjos.CookBook.domain.model.Recipe;
import pl.akjos.CookBook.domain.model.User;
import pl.akjos.CookBook.domain.repositories.RecipeRepository;
import pl.akjos.CookBook.recipe.dto.RecipeDetailsDTO;
import pl.akjos.CookBook.recipe.dto.RecipeListDTO;
import pl.akjos.CookBook.recipe.dto.RecipeToSaveDTO;
import pl.akjos.CookBook.user.UserService;
import pl.akjos.CookBook.utils.SecurityUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final static Integer SIZE = 3;

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

    @Override
    public List<RecipeListDTO> getAll(Integer page) {
        String username = SecurityUtils.getUsername();
        Long userId = userService.getUserByName(username).getId();

        Pageable pageable = PageRequest.of(page, SIZE);

        log.debug("Get recipe list size = {}, page = {} by user id = {} from database", SIZE, page, userId);

        List<RecipeListDTO> recipesDTOList = recipeRepository.getRecipesByUserId(userId, pageable);

        return recipesDTOList;
    }

    @Override
    public Integer getNumberPages() {
        String username = SecurityUtils.getUsername();
        Integer countRecipe = recipeRepository.countByUserId(userService.getUserByName(username).getId());
        Integer page = (countRecipe - 1) / SIZE;
        log.debug("Number recipe: {} Number page: {} for username: {}", countRecipe, page, username);
        return (page > 0) ? page : 0;
    }

    @Override
    public RecipeDetailsDTO getRecipeByIdAndUsername(Long id, String username) {
        log.debug("Get recipe by id: {} and username: {}", id, username);
        Optional<RecipeDetailsDTO> recipe = recipeRepository.findRecipeByIdAndUserId(id, username);
        if (!recipe.isPresent()) {
            throw new NoSuchElementException("No recipe details on this id for this user");
        }
        return recipe.get();
    }


}
