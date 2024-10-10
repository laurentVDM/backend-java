package be.vinci.utils;

import be.vinci.domain.DomainFactory;
import be.vinci.domain.DomainFactoryImpl;
import be.vinci.services.FilmDataService;
import be.vinci.services.FilmDataServiceImpl;
import be.vinci.services.UserDataService;
import be.vinci.services.UserDataServiceImpl;
import org.glassfish.hk2.utilities.binding.AbstractBinder;


import jakarta.inject.Singleton;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ApplicationBinder extends AbstractBinder {

  @Override
  protected void configure() {
    bind(DomainFactoryImpl.class).to(DomainFactory.class).in(Singleton.class);
    bind(FilmDataServiceImpl.class).to(FilmDataService.class).in(Singleton.class);
    bind(UserDataServiceImpl.class).to(UserDataService.class).in(Singleton.class);
  }
}
