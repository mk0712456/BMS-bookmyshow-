package com.example.book_my_show.dtos;


import com.example.book_my_show.models.Ticket;
import lombok.Data;

@Data
public class BookTicketResponseDTO {
    private Response response;
    private Ticket ticket;
}
