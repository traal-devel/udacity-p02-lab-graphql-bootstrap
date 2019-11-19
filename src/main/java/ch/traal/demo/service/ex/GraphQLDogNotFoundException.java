package ch.traal.demo.service.ex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

/**
 * 
 * Some of this has been handled in the above for the Query and Mutation. 
 * You might be tempted to fully re-use your code for DogNotFoundException 
 * from earlier, but we need a few changes for it to work properly with GraphQL 
 * (note that if you were also adding on a separate REST API using a service 
 * and controller, you may want to use separate exception handling for it). 
 * This time, you'll want to have it implement a GraphQLError, and no 
 * longer use the @ResponseStatus annotation we used with the REST API.
 * 
 * @author traal-devel
 */
public class GraphQLDogNotFoundException 
       extends RuntimeException 
       implements GraphQLError {

  
  /* constants */
  /** Added by eclipse. */
  private static final long serialVersionUID = -4344237159609155761L;
  
  
  /* member variables */
  private Map<String, Object> m_hmExtensions = new HashMap<>();
  
  
  /* constructors */
  public GraphQLDogNotFoundException(String message, Long invalidDogId) {
    super(message);
    this.m_hmExtensions.put("invalidDogId", invalidDogId);
  }

  
  /* methods */
  @Override
  public List<SourceLocation> getLocations() {
    return null;
  }
  
  @Override
  public Map<String, Object> getExtensions() {
    return this.m_hmExtensions;
  }
  
  @Override
  public ErrorType getErrorType() {
    return ErrorType.DataFetchingException;
  }

}
