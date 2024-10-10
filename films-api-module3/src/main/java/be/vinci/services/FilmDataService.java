package be.vinci.services;

import be.vinci.domain.Film;
import java.util.List;

public interface FilmDataService {

  List<Film> getAll(int minimumDuration);

  Film getOne(int id);

  Film createOne(Film film);

  Film deleteOne(int id);

  Film updateOne(Film film, int id);

  int nextFilmId();
}
