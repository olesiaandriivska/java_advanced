package com.javaadvanced.controller;

import com.javaadvanced.entity.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController                 //json
//@Controller                     //поаертає html
//@Bean                     //створює екземпляр
@RequestMapping("/movies")
public class MovieController {
    private List<Movie> movies = new ArrayList<>();

    {
        movies.add(new Movie(1, "aaa", 125));
        movies.add(new Movie(2, "nnn", 110));
    }

    //    @GetMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
//    public @ResponseBody List<Movie> getMovies(){
//        return movies;
//    }
    @GetMapping
    public List<Movie> getMovies() {
        return movies;
    }


    @GetMapping(value = "/{id}")
    public Movie getMovie(@PathVariable int id) {
        return movies.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst().orElseThrow(() -> new RuntimeException("jjjj"));
    }

    @PostMapping
    public Movie post(Movie movie) {
        movie.setId(movies.size() + 1);
        movies.add(movie);
        return movie;
    }


}

