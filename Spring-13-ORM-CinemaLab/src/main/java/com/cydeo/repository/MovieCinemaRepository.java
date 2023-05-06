package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id

    Optional<MovieCinema> findById (Long id);


    //Write a derived query to count all movie cinemas with a specific cinema id

    Integer countAllByCinemaId(Long id);


    //Write a derived query to count all movie cinemas with a specific movie id
    List<MovieCinema> findAllByMovieId (Long id);


    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime localDateTime);


    //Write a derived query to find the top 3 expensive movies

    List<MovieCinema> findFirst3OrderByMoviePriceDesc();


    //Write a derived query to list all movie cinemas that contain a specific movie name

    List<MovieCinema> findAllByMovie_NameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location

    List<MovieCinema> findAllByCinema_Location_Name(String name);



    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date


    @Query("select mc from MovieCinema mc where mc.dateTime > ?1")
    List<MovieCinema> findAllMovieCinemaByDateTimeAfter(@Param("dateTime") LocalDateTime localDateTime);




    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id

    @Query(value = "select count(*) from movie_cinema where cinema_id = ?1", nativeQuery = true)
    Integer countMovieCinemaById (Long id);


    //Write a native query that returns all movie cinemas by location name

//    @Query
    List<MovieCinema> retrieveAllMoviesByLocationName (@Param("name") String name);




}
