package be.vinci.api.filters;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;

public class TokenDecodingException extends WebApplicationException {
  public TokenDecodingException() {
    super(Response.status(Response.Status.UNAUTHORIZED)
        .build());
  }

  public TokenDecodingException(String message) {
    super(Response.status(Response.Status.UNAUTHORIZED)
        .entity(message)
        .type("text/plain")
        .build());
  }

  public TokenDecodingException(Throwable cause) {
    super(Response.status(Response.Status.UNAUTHORIZED)
        .entity(cause.getMessage())
        .type("text/plain")
        .build());
  }
}
