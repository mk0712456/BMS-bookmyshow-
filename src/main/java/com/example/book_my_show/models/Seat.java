package com.example.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity(name = "seats")
public class Seat extends BaseModel{
    private String name;
    private SeatType seatType;
    private Screen screen;
}
