package ch.traal.demo.service.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Dog not found")
public class DogNotFoundException 
       extends RuntimeException {

  

  /* constants */
  /** Added by eclipse */
  private static final long serialVersionUID = -6036450267455361684L;

  
  /* member variables */

  
  /* constructors */
  public DogNotFoundException() {
    super();
  }
  
  public DogNotFoundException(String msg) {
    super(msg);
  }

  
  /* methods */

}
