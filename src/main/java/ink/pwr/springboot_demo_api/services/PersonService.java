package ink.pwr.springboot_demo_api.services;

import ink.pwr.springboot_demo_api.models.Person;
import ink.pwr.springboot_demo_api.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    public Optional<Person> updatePerson(Long id, Person personDetails) {
        return personRepository.findById(id).map(existingPerson -> {
            existingPerson.setFirstName(personDetails.getFirstName());
            existingPerson.setLastName(personDetails.getLastName());
            return personRepository.save(existingPerson);
        });
    }

    public boolean deletePerson(Long id) {
        return personRepository.findById(id).map(person -> {
            personRepository.delete(person);
            return true;
        }).orElse(false);
    }
}
