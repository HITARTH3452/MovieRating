package com.Onito.MovieRatings.controllers;

import com.Onito.MovieRatings.models.Movies;
import com.Onito.MovieRatings.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("top10")
    public List<Movies> getTop10(){
        return movieService.getLongestRun();
    }

    @PostMapping("addMovie")
    public String addMovie(@RequestBody Movies movies){
        movieService.addMovie(movies);
        return "success";
    }

    @GetMapping("aboveRating")
    public List<Movies> getMovieAboveRating(){
        return movieService.getMovieAbove();
    }

    @GetMapping("sumVotes")
    public List<Movies> getWithSumVotes(){
        return movieService.getMovieWithSumVotes();
    }

    @PutMapping("incRuntime")
        public String IncRunTime(){
            movieService.IncRunTime();
            return "updates";

    }
}
