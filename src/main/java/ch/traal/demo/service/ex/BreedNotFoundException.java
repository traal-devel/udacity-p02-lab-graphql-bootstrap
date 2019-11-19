package ch.traal.demo.service.ex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;


/**
 * @author traal-devel
 */
public class BreedNotFoundException 
       extends RuntimeException 
       implements GraphQLError {

  
  /* constants */
  /** Added by eclipse */
  private static final long serialVersionUID = 1848758268942859207L;

  
  /* member variables */
  private Map<String, Object> m_hmExtension  = new HashMap<>();  
  
  
  /* constructors */
  public BreedNotFoundException() {
    super();
  }
  
  public BreedNotFoundException(String message, String invalidBreed) {
    super(message);
    
    this.m_hmExtension.put("invalidId", invalidBreed);
  }
  
  
  /* methods */
  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }
  
  @Override
  public Map<String, Object> getExtensions() {
    return this.m_hmExtension;
  }

  @Override
  public ErrorType getErrorType() {
    return ErrorType.DataFetchingException;
  }

}
