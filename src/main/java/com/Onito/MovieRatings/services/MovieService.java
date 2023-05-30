package com.Onito.MovieRatings.services;

import com.Onito.MovieRatings.models.Movies;
import com.Onito.MovieRatings.repos.IMovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    IMovieRepo movieRepo;
    public List<Movies> getLongestRun() {
        return movieRepo.findTop10MoviesByRuntime();
    }

    public void addMovie(Movies movies) {
        movieRepo.save(movies);
    }

    public List<Movies> getMovieAbove() {
       return movieRepo.findMoviesWithRatingGreaterThanSix();
    }

    public List<Movies> getMovieWithSumVotes() {
        return movieRepo.findMoviesByGenreWithSubtotals();
    }

    public void IncRunTime() {
         movieRepo.incrementRuntimeMinutes();
    }
}
