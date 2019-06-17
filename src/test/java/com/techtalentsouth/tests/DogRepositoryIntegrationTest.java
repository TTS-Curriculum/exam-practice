package com.techtalentsouth.tests;

import com.techtalentsouth.com.techtalentsouth.data.DogRepository;
import com.techtalentsouth.com.techtalentsouth.models.Dog;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class DogRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DogRepository repo;

    @Test
    public void findByNameShouldReturnTheCorrectDog() {
        Dog cujo = new Dog("Cujo");
        entityManager.persistAndFlush(cujo);

        Dog found = repo.findByName(cujo.getName());
        assertEquals("Cujo", found.getName());
    }

    @Test
    public void findAllShouldReturnAListOfAllDogs() {
        Dog cujo = new Dog("Cujo");
        Dog lassie = new Dog("Lassie");
        Dog tillie = new Dog("Tillie");

        entityManager.persist(cujo);
        entityManager.persist(lassie);
        entityManager.persist(tillie);
        entityManager.flush();

        List<Dog> dogs = Arrays.asList(cujo, lassie, tillie);
        List<Dog> foundDogs = repo.findAll();
        assertIterableEquals(dogs, foundDogs);
    }

    // TODO: Write comprehensive test cases here
}
