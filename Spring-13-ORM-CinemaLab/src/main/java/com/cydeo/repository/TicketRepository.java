package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long userId);

    //Write a derived query to list all tickets by specific email

    List<Ticket> findAllByUserAccountEmail(String email);



    //Write a derived query to count how many tickets are sold for a specific movie

    Integer countAllByMovieCinema_MovieName(String name);


    //Write a derived query to list all tickets between a range of dates

    List<Ticket> findAllByDateTimeBetween(LocalDateTime localDateTime1, LocalDateTime localDateTime2);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user


    @Query("select t from Ticket t where t.userAccount.id = ?1")
    List<Ticket> fetchBuUserId(@Param("userId") Long userId);


    //Write a JPQL query that returns all tickets between a range of dates

//    List<Ticket> fetch


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought

    @Query(value ="select count(*) from ticket where user_account_id = ?1", nativeQuery = true)
    Integer retrAllByUserAccountId(@Param("userId") Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value ="select count(*) from ticket where user_account_id = ?1 and date_time between ?2 and ?3", nativeQuery = true)
    Integer retrCountByUserInDateRange(@Param("userId") Long userId, @Param("dateTime1") LocalDateTime time1, @Param("dataTime2") LocalDateTime time2);


    //Write a native query to distinct all tickets by movie name
//    @Query(value ="", nativeQuery = true)
//    List<Ticket> fetchBuUserId(@Param("userId") Long userId);

    //Write a native query to find all tickets by user email

//    @Query(value ="", nativeQuery = true)
//    List<Ticket> fetchBuUserId(@Param("userId") Long userId);


    //Write a native query that returns all tickets
//    @Query(value ="", nativeQuery = true)
//    List<Ticket> fetchBuUserId(@Param("userId") Long userId);


    //Write a native query to list all tickets where a specific value should be containable
    // in the username or name or movie name
//    @Query(value ="", nativeQuery = true)
//    List<Ticket> fetchBuUserId(@Param("userId") Long userId);

//    @Query(value = "", nativeQuery = true)
    //ILIKE concat('%',?1,'%')

}
