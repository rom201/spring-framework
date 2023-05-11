package com.cydeo.bootstrap;


import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

//    private final AccountRepository accountRepository;
//    private final CinemaRepository cinemaRepository;
//    private final MovieRepository movieRepository;
//    private final MovieCinemaRepository movieCinemaRepository;
//    private final TicketRepository ticketRepository;
    private final GenreRepository genreRepository;
    private final UserRepository userRepository;

    public DataGenerator(GenreRepository genreRepository, UserRepository userRepository) {
        this.genreRepository = genreRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {


        System.out.println(genreRepository.fetchAll());
        System.out.println(userRepository.fetchAllUsers());




    }
}