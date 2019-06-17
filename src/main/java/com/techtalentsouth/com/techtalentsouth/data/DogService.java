package com.techtalentsouth.com.techtalentsouth.data;

import com.techtalentsouth.com.techtalentsouth.models.Dog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DogService {
    List<Dog> getDogs();

    Dog getDogById(Integer id);

    Dog getDogByBreed(String breed);

    Dog getDogByName(String name);

    Dog createDog(Dog dog);

    Dog updateDog(Dog dog);

    void deleteDogById(Integer id);

    void deleteAllDogs();
}
