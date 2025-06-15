package Mongo.animal.repository;

import Mongo.animal.entity.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntityRepository extends MongoRepository<Entity, String> {
	
}
