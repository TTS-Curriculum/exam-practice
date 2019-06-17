package com.techtalentsouth.controllers;

import com.techtalentsouth.com.techtalentsouth.data.DogService;
import com.techtalentsouth.com.techtalentsouth.models.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogRestController {

    @Autowired
    private DogService service;

    @RequestMapping(method = RequestMethod.POST, value = "/dogs")
    public void createDog(@RequestBody Dog dog) {
        service.createDog(dog);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dogs")
    public List<Dog> getAllDogs() {
        return service.getDogs();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dogs/{id}")
    public Dog getDogByNumber(@RequestParam(value = "id") int id) {
        return service.getDogById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/dogs/{id}")
    public Dog updateDogByNumber(@RequestParam(value = "id") int id, @RequestBody Dog dog) {
        return service.updateDog(dog);
    }

    // TODO: Create a method to delete Dogs by ID :(
    // TODO: Create a method to delete all Dogs :(
}
