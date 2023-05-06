package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findByName (String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findAllByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findAllByDurationIn(List<Integer> durations);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateAfter  (LocalDate releaseDate);


    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(MovieState state, MovieType type);//enums



    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
//    @Query("select m from Movie m where m.price > ?1 and m.price < ?1")
    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> getByPriceBetween (@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);

    //Write a JPQL query that returns all movie names
    @Query("select m.name from Movie m")
    List<String> fetchAllNames ();  // return is name - String


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "select * from movie where name = ?1", nativeQuery = true)
    Optional<Movie> retrieveByName (@Param("name") String name);


    //Write a native query that return the list of movies in a specific range of prices
    @Query(value = "select * from movie where price between ?1 and ?2", nativeQuery = true)
    List<Movie> retrieveByPriceRange (@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "SELECT * FROM movie WHERE duratin IN ?1", nativeQuery = true)
    List<Movie> retrieveByDurationInRange(@Param("duration") List<Integer> durations);

    //Write a native query to list the top 5 most expensive movies
    @Query(value = "SELECT * FROM movies ORDER BY price DESC LIMIT 5", nativeQuery = true)
    List<Movie> top5ExpensiveMovies();


}
