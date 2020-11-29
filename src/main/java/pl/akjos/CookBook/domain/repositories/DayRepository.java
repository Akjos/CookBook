package pl.akjos.CookBook.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.akjos.CookBook.domain.model.Day;

public interface DayRepository extends JpaRepository<Day, Integer> {
}
