package ink.pwr.springboot_demo_api.repositories;

import ink.pwr.springboot_demo_api.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
