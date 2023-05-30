package com.Onito.MovieRatings.repos;

import com.Onito.MovieRatings.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepo extends JpaRepository<Movies,String> {
    @Query("SELECT m.tconst AS tconst, m.primaryTitle AS primaryTitle, m.runtimeMinutes AS runtimeMinutes, m.genres AS genres " + "FROM Movies m " + "ORDER BY m.runtimeMinutes DESC " + "LIMIT 10")
    List<Movies> findTop10MoviesByRuntime();


    @Query("SELECT m.tconst AS tconst, m.primaryTitle AS primaryTitle, m.genres AS genres, m.averageRating AS averageRating " + "FROM Movies m " + "WHERE m.averageRating > 6.0 " + "ORDER BY m.averageRating ASC")
    List<Movies> findMoviesWithRatingGreaterThanSix();

    @Query(nativeQuery = true, value = "SELECT m.genres AS genres, SUM(m.numVotes) AS numVotesSubtotal " + "FROM Movies m " + "GROUP BY m.genres")
    List<Movies> findMoviesByGenreWithSubtotals();

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE Movies " + "SET runtimeMinutes = CASE " + "WHEN genres = 'Documentary' THEN runtimeMinutes + 15 " + "WHEN genres = 'Animation' THEN runtimeMinutes + 30 " + "ELSE runtimeMinutes + 45 " + "END")
    void incrementRuntimeMinutes();
}
