package com.techtalentsouth.com.techtalentsouth.data;

import com.techtalentsouth.com.techtalentsouth.models.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogRepository extends JpaRepository<Dog, Integer> {
    public Dog findByName(String name);

    public Dog findByBreed(String breed);
}
