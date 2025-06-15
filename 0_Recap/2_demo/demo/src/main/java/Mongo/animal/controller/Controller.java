package Mongo.animal.controller;

import Mongo.animal.entity.Entity;
import Mongo.animal.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/animals")
public class Controller {

    @Autowired
    private EntityService service;

    @GetMapping
    public List<Entity> getAllAnimals() {
        return service.getAllAnimals();
    }

    @GetMapping("/{id}")
    public Optional<Entity> getAnimalById(@PathVariable String id) {
        return service.getAnimalById(id);
    }

    @PostMapping
    public Entity addAnimal(@RequestBody Entity animal) {
        return service.addAnimal(animal);
    }

    @PutMapping("/{id}")
    public Entity updateAnimal(@PathVariable String id, @RequestBody Entity updatedAnimal) {
        return service.updateAnimal(id, updatedAnimal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable String id) {
        service.deleteAnimal(id);
    }
}
