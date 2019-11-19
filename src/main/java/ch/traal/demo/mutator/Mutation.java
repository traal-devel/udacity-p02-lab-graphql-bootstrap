package ch.traal.demo.mutator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import ch.traal.demo.entity.Dog;
import ch.traal.demo.repository.DogRepository;
import ch.traal.demo.service.ex.BreedNotFoundException;
import ch.traal.demo.service.ex.GraphQLDogNotFoundException;

@Component
public class Mutation implements GraphQLMutationResolver {

  
  /* member variables */
  @Autowired
  private DogRepository dogRepository;
  
  /* constructors */

  /* methods */
  public boolean deleteDogBreed(String breed) {
    int iTupelsChanged = this.dogRepository.deleteByBreed(breed);
    if (iTupelsChanged < 1) {
      throw new BreedNotFoundException("Breed not found. " , breed);
    }
    
    return iTupelsChanged > 0 ;
  }
  
  // :INFO: Solution p02-16 --> DO NOT DO THIS... BAD CODE.
  //        Use the advantages of a db to this.
//  public boolean deleteDogBreed(String breed) {
//    boolean deleted = false;
//    Iterable<Dog> allDogs = dogRepository.findAll();
//    // Loop through all dogs to check their breed
//    for (Dog d:allDogs) {
//       if (d.getBreed().equals(breed)) {
//           // Delete if the breed is found
//           dogRepository.delete(d);
//           deleted = true;
//       }
//    }
//    // Throw an exception if the breed doesn't exist
//    if (!deleted) {
//        throw new BreedNotFoundException("Breed Not Found", breed);
//    }
//    return deleted;
//  }
  
  public Dog updateDogName(Long id, String newName) {
    Optional<Dog> opDog  = this.dogRepository.findById(id);
    Dog dog = null;
    
    if (opDog.isPresent()) {
      dog = opDog.get();
      dog.setName(newName);
      
      dog = this.dogRepository.save(dog);
      
    } else {
      throw new GraphQLDogNotFoundException("Dog not found.", id);
    }
    
    return dog;
  }

}
