package ch.traal.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import ch.traal.demo.entity.Dog;

public interface DogRepository extends CrudRepository<Dog, Long>{

  
  /* methods */
  @Query(
    value = "SELECT DISTINCT d.breed FROM Dog d",
    nativeQuery = true
  )
  List<String> findAllBreeds();
  
  @Query(
    value = "SELECT breed FROM Dog d WHERE d.id=:id",
    nativeQuery = true
  )
  String findBreedById(Long id);
  
  @Query(
    value = "SELECT DISTINCT d.name FROM Dog d",
    nativeQuery = true
  )
  List<String> findAllNames();
  
  @Transactional
  @Modifying
  @Query(
    value = "DELETE FROM Dog d WHERE d.breed=:breed",
    nativeQuery = true
  )
  int deleteByBreed(String breed);
  
}
