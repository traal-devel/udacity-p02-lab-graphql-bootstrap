package ch.traal.demo.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import ch.traal.demo.entity.Dog;
import ch.traal.demo.repository.DogRepository;
import ch.traal.demo.service.ex.DogNotFoundException;

@Component
public class Query implements GraphQLQueryResolver {


  /* member variables */
  @Autowired
  private DogRepository dogRepository;
  
  /* constructors */

  
  /* methods */
  public Iterable<Dog> findAllDogs() {
    return this.dogRepository.findAll();
  }
  
  public Dog findDogById(Long id) {
    return this.dogRepository
                  .findById(id)
                  .orElseThrow(DogNotFoundException::new);
  }
  
  // Solution p02-16
//  public Dog findDogById(Long id) {
//    Optional<Dog> optionalDog = dogRepository.findById(id);
//    if (optionalDog.isPresent()) {
//        return optionalDog.get();
//    } else {
//        throw new DogNotFoundException("Dog Not Found", id);
//    }
//  }

}
