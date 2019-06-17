package com.techtalentsouth.com.techtalentsouth.data;

import com.techtalentsouth.com.techtalentsouth.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DogServiceImpl implements DogService {

    @Autowired
    private DogRepository repo;

    @Override
    public List<Dog> getDogs() {
        return repo.findAll();
    }

    @Override
    public Dog getDogById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Dog getDogByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public Dog getDogByBreed(String breed) {
        return repo.findByBreed(breed);
    }


    @Override
    public Dog createDog(Dog dog) {
        return repo.save(dog);
    }

    @Override
    public void deleteDogById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public Dog updateDog(Dog dog) {
        return repo.save(dog);
    }

    @Override
    public void deleteAllDogs() {
        repo.deleteAll();
    }
}
