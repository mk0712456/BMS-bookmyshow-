package com.example.book_my_show.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.Date;
@Data
@Entity
public class Show extends BaseModel{
    private String name;
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private Movie movie;
    private Date startTime;
}
