package com.example.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel{
    private String name;
    private SeatType seatType;
}