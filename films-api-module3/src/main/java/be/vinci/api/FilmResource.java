package be.vinci.api;

import be.vinci.api.filters.Authorize;
import be.vinci.domain.Film;
import be.vinci.domain.User;
import be.vinci.services.FilmDataService;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.server.ContainerRequest;

import java.util.List;

@Singleton
@Path("films")
public class FilmResource {
    @Inject
    private FilmDataService myFilmDataService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Film> getAll(@DefaultValue("-1") @QueryParam("minimum-duration") int minimumDuration) {
        return myFilmDataService.getAll(minimumDuration);
    }


    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Film getOne(@PathParam("id") int id) {
        Film filmFound = myFilmDataService.getOne(id);
        if (filmFound == null)
            throw new WebApplicationException("No film found",Response.Status.NOT_FOUND);

        return filmFound;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Authorize
    public Film createOne(Film film, @Context ContainerRequest request) {
        User authenticatedUser = (User) request.getProperty("user");
        System.out.println("A new film is added by " + authenticatedUser.getLogin() );
        if (film == null || film.getTitle() == null || film.getTitle().isBlank())
            throw new WebApplicationException("Lacks of mandatory info",Response.Status.BAD_REQUEST);
        return myFilmDataService.createOne(film);
    }


    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Authorize
    public Film deleteOne(@PathParam("id") int id) {
        if (id == 0) // default value of an integer => has not been initialized
            throw new WebApplicationException("Lacks of mandatory id info",Response.Status.BAD_REQUEST);
        Film deletedFilm = myFilmDataService.deleteOne(id);
        if (deletedFilm == null)
            throw new WebApplicationException("Ressource not found",Response.Status.NOT_FOUND);
        return deletedFilm;
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Authorize
    public Film updateOne(Film film, @PathParam("id") int id) {
        if (id == 0 || film == null || film.getTitle() == null || film.getTitle().isBlank())
            throw new WebApplicationException("Lacks of mandatory info",Response.Status.BAD_REQUEST);
        Film updatedFilm = myFilmDataService.updateOne(film, id);
        if (updatedFilm == null)
            throw new WebApplicationException("Ressource not found",Response.Status.NOT_FOUND);
        return updatedFilm;
    }


}
