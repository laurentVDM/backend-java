package be.vinci.domain;

public class DomainFactoryImpl implements DomainFactory {
  @Override
  public Film getFilm() {
    return new FilmImpl();
  }

  @Override
  public User getUser() {
    return new UserImpl();
  }
}
