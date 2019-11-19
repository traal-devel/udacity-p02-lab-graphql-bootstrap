package ch.traal.demo.service;

import java.util.List;

import ch.traal.demo.entity.Dog;

public interface DogService {

  
  /* methods */
  
  List<Dog> retrieveDogs();
  
  List<String> retrieveDogBreeds();
  
  String retrieveDogBreedById(Long id);
  
  String retrieveDogBreedByIdV2(Long id);
  
  List<String> retrieveDogNames();
  
}