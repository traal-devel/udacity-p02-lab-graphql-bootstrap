package ch.traal.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.traal.demo.entity.Dog;
import ch.traal.demo.repository.DogRepository;
import ch.traal.demo.service.ex.DogNotFoundException;

@Service
public class DogServiceImpl implements DogService {


  /* member variables */
  @Autowired
  private DogRepository dogRepository;
  
  /* constructors */
  public DogServiceImpl() {
    super();
  }
  
  /* methods */
  @Override
  public List<String> retrieveDogBreeds() {
    return this.dogRepository.findAllBreeds();
  }
  
  @Override
  public String retrieveDogBreedById(Long id) {
     Optional<Dog> dog  = this.dogRepository.findById(id);
     return dog.isEmpty() ? null : dog.get().getBreed();
  }
  
  @Override
  public String retrieveDogBreedByIdV2(Long id) {
    Optional<String> optionalBreed = 
              Optional.ofNullable(dogRepository.findBreedById(id));
    return optionalBreed.orElseThrow(DogNotFoundException::new);
  }

  
  @Override
  public List<String> retrieveDogNames() {
    return this.dogRepository.findAllNames();
  }

  @Override
  public List<Dog> retrieveDogs() {
    return (List<Dog>)this.dogRepository.findAll();
  }

}
