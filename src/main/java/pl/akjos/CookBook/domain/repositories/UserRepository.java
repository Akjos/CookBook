package pl.akjos.CookBook.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akjos.CookBook.domain.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
