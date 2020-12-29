package pl.akjos.CookBook.recipe;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.akjos.CookBook.domain.model.Recipe;
import pl.akjos.CookBook.domain.model.User;
import pl.akjos.CookBook.domain.repositories.RecipeRepository;
import pl.akjos.CookBook.recipe.dto.RecipeToSaveDTO;
import pl.akjos.CookBook.user.UserService;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RecipeServiceImplTest {

    private String RECIPE_NAME = "Recipe name";
    private String RECIPE_DESCRIPTION = "Recipe description";
    private String RECIPE_INGREDIENTS = "Recipe ingredients";

    @Mock
    private RecipeRepository recipeRepositoryMock;

    @Mock
    private UserService userServiceMock;

    @InjectMocks
    private RecipeServiceImpl testObject;

    @Before
    public void setMockForSpringSecurity() {
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext(securityContext);
    }

    @Test
    public void shouldSaveRecipe() {
//        given
        ArgumentCaptor<Recipe> argumentCaptor = ArgumentCaptor.forClass(Recipe.class);
        RecipeToSaveDTO recipeDTO = RecipeToSaveDTO.builder()
                .name(RECIPE_NAME)
                .description(RECIPE_DESCRIPTION)
                .ingredients(RECIPE_INGREDIENTS)
                .build();
        Recipe recipe = new Recipe();
        recipe.setId(1L);

//        when
        testObject.add(recipeDTO);

//        then
        verify(recipeRepositoryMock, Mockito.times(1)).save(argumentCaptor.capture());
        assertEquals(recipeDTO.getName(), argumentCaptor.getValue().getName());
        assertEquals(recipeDTO.getIngredients(), argumentCaptor.getValue().getIngredients());
        assertEquals(recipeDTO.getDescription(), argumentCaptor.getValue().getDescription());
    }

    @Test
    public void shouldReturnIntegerWhenGetNumberPages() {
//        given
        User user = User.builder().id(1L).build();
        when(userServiceMock.getUserByName(null)).thenReturn(user);
        when(recipeRepositoryMock.countByUserId(anyLong())).thenReturn(15);

//        when
        Integer numberPages = testObject.getNumberPages();

//        then
        assertTrue(numberPages>0);
    }

    @Test
    public void shouldReturnZeroWhenGetNumberPages() {
//        given
        User user = User.builder().id(1L).build();
        when(userServiceMock.getUserByName(null)).thenReturn(user);
        when(recipeRepositoryMock.countByUserId(anyLong())).thenReturn(0);

//        when
        Integer numberPages = testObject.getNumberPages();

//        then
        assertTrue(numberPages==0);
    }


//        given
//        when
//        then
}