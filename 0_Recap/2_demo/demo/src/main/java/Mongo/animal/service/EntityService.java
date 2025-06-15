package Mongo.animal.service;

import Mongo.animal.entity.Entity;
import Mongo.animal.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntityService {

    @Autowired
    private EntityRepository repository;

    public List<Entity> getAllAnimals() {
        return repository.findAll();
    }

    public Optional<Entity> getAnimalById(String id) {
        return repository.findById(id);
    }

    public Entity addAnimal(Entity animal) {
        return repository.save(animal);
    }

    public Entity updateAnimal(String id, Entity updatedAnimal) {
        updatedAnimal.setId(id);
        return repository.save(updatedAnimal);
    }

    public void deleteAnimal(String id) {
        repository.deleteById(id);
    }
}
