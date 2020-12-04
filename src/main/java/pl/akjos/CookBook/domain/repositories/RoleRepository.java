package pl.akjos.CookBook.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akjos.CookBook.domain.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getRoleByName(String name);
}
