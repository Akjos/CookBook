package pl.akjos.CookBook.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.akjos.CookBook.domain.model.Role;
import pl.akjos.CookBook.domain.model.User;
import pl.akjos.CookBook.domain.repositories.RoleRepository;
import pl.akjos.CookBook.domain.repositories.UserRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public void saveUser(UserRegisterDTO userToSave) {
        Role userRole = roleRepository.getRoleByName("ROLE_USER");
        User user = User.builder()
                .username(userToSave.getUsername())
                .email(userToSave.getEmail())
                .password(passwordEncoder.encode(userToSave.getPassword()))
                .role(userRole)
                .build();

        User savedUser = userRepository.save(user);

        log.debug("User to save in DB: {}", savedUser);
    }

    public User getUserByName(String username) {
        return userRepository.getUserByUsername(username);
    }
}
