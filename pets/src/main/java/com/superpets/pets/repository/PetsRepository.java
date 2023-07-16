package com.superpets.pets.repository;

import com.superpets.pets.model.PetsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

//mongo to model
public interface PetsRepository extends MongoRepository<PetsModel,String> {

}
