package com.example.demo.Controllers;

import com.example.demo.Entities.Movie;
import com.example.demo.Dtos.MovieDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    // http://localhost:8080/movie
    @GetMapping("movie")
    public ResponseEntity<MovieDto> getMovie() {
        MovieDto movie = new MovieDto("1", "Lord of the Rings", 10);
        if( movie == null ) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movie);
    }

    // http://localhost:8080/movies/trending
    @GetMapping("movies/trending")
    public Iterable<MovieDto> getMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("2","Harry Potter",9));
        movies.add(new Movie("3", "Star Wars",7));
        movies.add(new Movie("4","I ran out of ideas",2));

        return movies
                .stream()
                .map(movie ->
                        new MovieDto(movie.getId()
                                , movie.getName()
                                , movie.getRating()))
                .toList();
    }

    // Spring BOOT REST API with Path Variable
    // http://localhost:8080/movie/5/A_nice_and_quaint_movie/9
    @GetMapping("movie/{id}/{name}/{rating}")
    public Movie moviePathVariable(@PathVariable String id,
                                   @PathVariable String name,
                                   @PathVariable int rating) {

        return new Movie(id,name,rating);
    }

    // Spring BOOT REST API with Request Parameter
    // http://localhost:8080/movie/query?id=12&name=The Hobbit&rating=8
    @GetMapping("movie/query")
    public Movie movieRequestVariable(@RequestParam String id,
                                      @RequestParam String name,
                                      @RequestParam int rating){
        return new Movie(id,name,rating);
    }
}
