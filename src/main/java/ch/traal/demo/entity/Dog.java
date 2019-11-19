package ch.traal.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The below code could be used to implement such an entity with the required 
 * attributes. Note that you should also include constructors for the class, 
 * as well as accessors and mutators for the three attributes. 
 * 
 * Important: The package name may differ depending on what you used during 
 * the set up of your project - make sure to adjust it to apply to 
 * your own project structure!
 * 
 * @author traal-devel
 */
@Entity
public class Dog {

  /* member variables */
  /* member variables */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String breed;
  private String origin;
  
  /* constructors */
  public Dog(Long id, String name, String breed, String origin) {
    super();
    this.id = id;
    this.name = name;
    this.breed = breed;
    this.origin = origin;
  }

  public Dog(String name, String breed) {
    this.name = name;
    this.breed = breed;
  }
  
  public Dog() {
    super();
  }
  
  
  /*  methods */
  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getBreed() {
    return breed;
  }
  
  public void setBreed(String breed) {
    this.breed = breed;
  }

  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }
  
}
