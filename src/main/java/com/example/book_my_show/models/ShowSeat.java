package com.example.book_my_show.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "show_seats")
public class ShowSeat extends BaseModel{
    @ManyToOne
    private Show show;
    @ManyToOne
    private Seat seat;
    @Enumerated(value = EnumType.ORDINAL)
    private SeatStatus seatStatus;
    @ManyToOne
    private User bookedBy;
}
