package pl.akjos.CookBook.setup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.akjos.CookBook.domain.model.Role;
import pl.akjos.CookBook.domain.repositories.RoleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StartingDataService {

    private final String ROLE_USER_NAME = "ROLE_USER";
    private final String ROLE_ADMIN_NAME = "ROLE_ADMIN";

    private final RoleRepository roleRepository;

    public void start() {
        setRoleInDB();
    }

    private void setRoleInDB() {
        Role userRole = new Role();
        userRole.setName(ROLE_USER_NAME);
        Role adminRole = new Role();
        adminRole.setName(ROLE_ADMIN_NAME);
        roleRepository.saveAll(List.of(userRole, adminRole));
    }
}
