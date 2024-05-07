package com.example.book_my_show.models;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Movie extends BaseModel{
    private String name;
    private Genre genre;
}
