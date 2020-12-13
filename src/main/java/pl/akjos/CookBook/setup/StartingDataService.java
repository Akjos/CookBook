package pl.akjos.CookBook.setup;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.akjos.CookBook.domain.model.Recipe;
import pl.akjos.CookBook.domain.model.Role;
import pl.akjos.CookBook.domain.model.User;
import pl.akjos.CookBook.domain.repositories.RecipeRepository;
import pl.akjos.CookBook.domain.repositories.RoleRepository;
import pl.akjos.CookBook.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StartingDataService {

    private final String ROLE_USER_NAME = "ROLE_USER";
    private final String ROLE_ADMIN_NAME = "ROLE_ADMIN";
    private final String USER_LOGIN = "sojkprz";

    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    public void start() {
        setRoleInDB();
        setUserInDB();
        setRecipeInDB();
    }

    private void setRecipeInDB() {
        List<Recipe> recipeList = new ArrayList<>();

        Recipe recipe1 = Recipe.builder()
                .name("1 MIODOWE PANCAKES Z OWOCAMI")
                .description("Dobry start w nowy dzień ma smak miodowych pancakes na bazie mąki ryżowej z ulubionymi owocami. Koniecznie powiedz im dzień dobry!")
                .ingredients("mąka ryżowa – 400 g jajka – 2 szt. jogurt naturalny – 400 ml cynamon – ½ łyżeczki soda oczyszczona – 1 łyżeczka cukier – 1 łyżka sól – 1 szczypta olej kokosowy – 2 łyżki")
                .preparation("KROK 1: UBIJAMY BIAŁKA\n" +
                        "Białka jajek ubij na sztywno. Następnie połącz je z cukrem, solą, żółtkami, łyżką rozpuszczonego oleju kokosowego i jogurtem.\n" +
                        "\n" +
                        "KROK 2: WYRABIAMY MASĘ\n" +
                        "Mąkę połącz z sodą i dodaj do pozostałych składników. Całość mieszaj delikatnie do powstania jednolitej masy.\n" +
                        "\n" +
                        "KROK 3: SMAŻYMY PANCAKES\n" +
                        "Na patelni rozpuść resztę oleju kokosowego, poczekaj, aż się rozgrzeje, i smaż placki z obu stron na małym ogniu do zarumienienia.\n" +
                        "\n" +
                        "KROK 4: PODAJEMY PANCAKES\n" +
                        "Przełóż placki na talerz i polej je miodem. Udekoruj ulubionymi owocami. Jeśli są duże, pokrój je na kawałki.")
                .preparationTime(30)
                .user(userRepository.getUserByUsername(USER_LOGIN))
                .build();
        recipeList.add(recipe1);

        Recipe recipe2 = Recipe.builder()
                .name("2 MIODOWE PANCAKES Z OWOCAMI")
                .description("Dobry start w nowy dzień ma smak miodowych pancakes na bazie mąki ryżowej z ulubionymi owocami. Koniecznie powiedz im dzień dobry!")
                .ingredients("mąka ryżowa – 400 g jajka – 2 szt. jogurt naturalny – 400 ml cynamon – ½ łyżeczki soda oczyszczona – 1 łyżeczka cukier – 1 łyżka sól – 1 szczypta olej kokosowy – 2 łyżki")
                .preparation("KROK 1: UBIJAMY BIAŁKA\n" +
                        "Białka jajek ubij na sztywno. Następnie połącz je z cukrem, solą, żółtkami, łyżką rozpuszczonego oleju kokosowego i jogurtem.\n" +
                        "\n" +
                        "KROK 2: WYRABIAMY MASĘ\n" +
                        "Mąkę połącz z sodą i dodaj do pozostałych składników. Całość mieszaj delikatnie do powstania jednolitej masy.\n" +
                        "\n" +
                        "KROK 3: SMAŻYMY PANCAKES\n" +
                        "Na patelni rozpuść resztę oleju kokosowego, poczekaj, aż się rozgrzeje, i smaż placki z obu stron na małym ogniu do zarumienienia.\n" +
                        "\n" +
                        "KROK 4: PODAJEMY PANCAKES\n" +
                        "Przełóż placki na talerz i polej je miodem. Udekoruj ulubionymi owocami. Jeśli są duże, pokrój je na kawałki.")
                .preparationTime(30)
                .user(userRepository.getUserByUsername(USER_LOGIN))
                .build();
        recipeList.add(recipe2);

        Recipe recipe3 = Recipe.builder()
                .name("3 MIODOWE PANCAKES Z OWOCAMI")
                .description("Dobry start w nowy dzień ma smak miodowych pancakes na bazie mąki ryżowej z ulubionymi owocami. Koniecznie powiedz im dzień dobry!")
                .ingredients("mąka ryżowa – 400 g jajka – 2 szt. jogurt naturalny – 400 ml cynamon – ½ łyżeczki soda oczyszczona – 1 łyżeczka cukier – 1 łyżka sól – 1 szczypta olej kokosowy – 2 łyżki")
                .preparation("KROK 1: UBIJAMY BIAŁKA\n" +
                        "Białka jajek ubij na sztywno. Następnie połącz je z cukrem, solą, żółtkami, łyżką rozpuszczonego oleju kokosowego i jogurtem.\n" +
                        "\n" +
                        "KROK 2: WYRABIAMY MASĘ\n" +
                        "Mąkę połącz z sodą i dodaj do pozostałych składników. Całość mieszaj delikatnie do powstania jednolitej masy.\n" +
                        "\n" +
                        "KROK 3: SMAŻYMY PANCAKES\n" +
                        "Na patelni rozpuść resztę oleju kokosowego, poczekaj, aż się rozgrzeje, i smaż placki z obu stron na małym ogniu do zarumienienia.\n" +
                        "\n" +
                        "KROK 4: PODAJEMY PANCAKES\n" +
                        "Przełóż placki na talerz i polej je miodem. Udekoruj ulubionymi owocami. Jeśli są duże, pokrój je na kawałki.")
                .preparationTime(30)
                .user(userRepository.getUserByUsername(USER_LOGIN))
                .build();
        recipeList.add(recipe3);

        Recipe recipe4 = Recipe.builder()
                .name("4 MIODOWE PANCAKES Z OWOCAMI")
                .description("Dobry start w nowy dzień ma smak miodowych pancakes na bazie mąki ryżowej z ulubionymi owocami. Koniecznie powiedz im dzień dobry!")
                .ingredients("mąka ryżowa – 400 g jajka – 2 szt. jogurt naturalny – 400 ml cynamon – ½ łyżeczki soda oczyszczona – 1 łyżeczka cukier – 1 łyżka sól – 1 szczypta olej kokosowy – 2 łyżki")
                .preparation("KROK 1: UBIJAMY BIAŁKA\n" +
                        "Białka jajek ubij na sztywno. Następnie połącz je z cukrem, solą, żółtkami, łyżką rozpuszczonego oleju kokosowego i jogurtem.\n" +
                        "\n" +
                        "KROK 2: WYRABIAMY MASĘ\n" +
                        "Mąkę połącz z sodą i dodaj do pozostałych składników. Całość mieszaj delikatnie do powstania jednolitej masy.\n" +
                        "\n" +
                        "KROK 3: SMAŻYMY PANCAKES\n" +
                        "Na patelni rozpuść resztę oleju kokosowego, poczekaj, aż się rozgrzeje, i smaż placki z obu stron na małym ogniu do zarumienienia.\n" +
                        "\n" +
                        "KROK 4: PODAJEMY PANCAKES\n" +
                        "Przełóż placki na talerz i polej je miodem. Udekoruj ulubionymi owocami. Jeśli są duże, pokrój je na kawałki.")
                .preparationTime(30)
                .user(userRepository.getUserByUsername(USER_LOGIN))
                .build();
        recipeList.add(recipe4);

        recipeRepository.saveAll(recipeList);
    }

    private void setUserInDB() {
        User user = User.builder()
                .username(USER_LOGIN)
                .password(passwordEncoder.encode("password1"))
                .email("akjos@brak.com")
                .role(roleRepository.getRoleByName(ROLE_USER_NAME))
                .build();
        userRepository.save(user);
    }

    private void setRoleInDB() {
        Role userRole = new Role();
        userRole.setName(ROLE_USER_NAME);
        Role adminRole = new Role();
        adminRole.setName(ROLE_ADMIN_NAME);
        roleRepository.saveAll(List.of(userRole, adminRole));
    }
}
