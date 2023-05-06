package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name

    Optional<Movie> findByName (String name);

    //Write a derived query to list all movies between a range of prices

    List<Movie> findMovieByPriceBetween(BigDecimal priceStart, BigDecimal priceEnd);

    //Write a derived query to list all movies where duration exists in the specific list of duration

    List<Movie> findAllByDurationIn(List<Integer> durationList);

    //Write a derived query to list all movies with higher than a specific release date

    List<Movie> findAllByReleaseDateAfter(LocalDateTime localDateTime);


    //Write a derived query to list all movies with a specific state and type

    List<Movie> findAllByStateAndType(MovieState state, MovieType type);//enums





    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
//    @Query("select m from Movie m where m.price > ?1 and m.price < ?1")
    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> fetchByRengePrice (@Param("price") BigDecimal startPrice, @Param("price") BigDecimal endPrice);

    //Write a JPQL query that returns all movie names

    @Query("select m.name from Movie m")
    List<Movie> fetchAllNames ();




    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name

    @Query(value = "select * from movie where name = ?1", nativeQuery = true)
    Optional<Movie> fetchMovieByName (@Param("name") String name);



    //Write a native query that return the list of movies in a specific range of prices

    @Query(value = "select * from movie where price between ?1 and ?2", nativeQuery = true)
    List<Movie> retrByRengePrice (@Param("price") BigDecimal startPrice, @Param("price") BigDecimal endPrice);

    //Write a native query to return all movies where duration exists in the range of duration



    //Write a native query to list the top 5 most expensive movies


    List<Movie> top5Expens();


    //    @Query(value = "", nativeQuery = true)
    //ILIKE concat('%',?1,'%')

}
