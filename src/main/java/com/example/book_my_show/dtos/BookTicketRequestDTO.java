package com.example.book_my_show.dtos;

import lombok.Data;

import java.util.List;
@Data
public class BookTicketRequestDTO {
    private int userId;
    private int showId;
    private List<Integer> show_seatId;
}
