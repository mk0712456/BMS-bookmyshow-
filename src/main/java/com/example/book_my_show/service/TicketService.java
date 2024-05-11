package com.example.book_my_show.service;

import com.example.book_my_show.models.Ticket;

import java.util.List;

public interface TicketService {
   Ticket bookTicket(int user_id, int show_id, List<Integer> show_seat_ids ) throws Exception;
}
