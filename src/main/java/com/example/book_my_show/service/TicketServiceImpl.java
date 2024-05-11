package com.example.book_my_show.service;

import com.example.book_my_show.Repository.ShowRepository;
import com.example.book_my_show.Repository.ShowSeatRepository;
import com.example.book_my_show.Repository.TicketRepository;
import com.example.book_my_show.Repository.UserRepository;
import com.example.book_my_show.exceptions.InvalidBookTicketException;
import com.example.book_my_show.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class TicketServiceImpl implements TicketService{
    UserRepository userRepository;
    ShowRepository showRepository;
    ShowSeatRepository showSeatRepository;
    TicketRepository ticketRepository;
    @Autowired

    public TicketServiceImpl(UserRepository userRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.ticketRepository = ticketRepository;
    }


    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Override
    public Ticket bookTicket(int user_id, int show_id, List<Integer> show_seat_ids) throws Exception {

        Optional<User> userOptional = this.userRepository.findById(user_id);
        User user;
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        else{
            throw new InvalidBookTicketException("User not present in DB");
        }

        Optional<Show> showOptional = this.showRepository.findById(show_id);
        Show show;
        if(showOptional.isPresent()){
            show= showOptional.get();
        }
        else {
            throw new InvalidBookTicketException("Show is not present in db");
        }
        List<ShowSeat> showSeat =this.showSeatRepository.findById(show_seat_ids.get()).orElse(()-> {throw new InvalidBookTicketException("Invalid show_seat")});
        for(ShowSeat ss : showSeat){
            ss.setBookedBy(user);
            ss.setSeatStatus(SeatStatus.BOOKED);
        }
        showSeatRepository.saveAll(showSeat);
        //generate ticket and store in db
        Ticket ticket = new Ticket();
        ticket.setShow(show);
        ticket.setMovie(show.getMovie());
        ticket.setShowSeats(showSeat);
        ticket.setUser(user);

        return ticketRepository.save(ticket);
    }
}
