package com.example.book_my_show.controllers;

import com.example.book_my_show.dtos.BookTicketRequestDTO;
import com.example.book_my_show.dtos.BookTicketResponseDTO;
import com.example.book_my_show.dtos.Response;
import com.example.book_my_show.exceptions.InvalidBookTicketException;
import com.example.book_my_show.models.Ticket;
import com.example.book_my_show.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.print.Book;
@Controller
public class TicketController {
    private TicketService ticketService;
    @Autowired

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }
    @RequestMapping(path= /bookticket)
    public BookTicketResponseDTO bookTicket(BookTicketRequestDTO requestDTO){
        BookTicketResponseDTO responseDTO = new BookTicketResponseDTO();
        try{
            validateBookTicketRequest(requestDTO);
            Ticket ticket = ticketService.bookTicket(requestDTO.getUserId(), requestDTO.getShowId(), requestDTO.getShow_seatId());
            Response response = Response.getSuccessResponse();
            responseDTO.setResponse(response);
            responseDTO.setTicket(ticket);
        }
        catch (Exception e){

        }
        return null;
    }
    private static void validateBookTicketRequest(BookTicketRequestDTO requestDTO) throws InvalidBookTicketException {
        if(requestDTO.getUserId()<=0){
            throw  new InvalidBookTicketException("user_id cant be zero!!");
        }
        if(requestDTO.getShowId()<=0){
            throw new InvalidBookTicketException("showid cant be zero");
        }
        if(requestDTO.getShow_seatId() == null || requestDTO.getShow_seatId().isEmpty()){
            throw new InvalidBookTicketException("req_seats cant be empty");
        }
    }
}
