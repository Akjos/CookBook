package pl.akjos.CookBook.setup;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.akjos.CookBook.domain.model.Role;
import pl.akjos.CookBook.domain.model.User;
import pl.akjos.CookBook.domain.repositories.RoleRepository;
import pl.akjos.CookBook.domain.repositories.UserRepository;

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

    public void start() {
        setRoleInDB();
        setUserInDB();
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
