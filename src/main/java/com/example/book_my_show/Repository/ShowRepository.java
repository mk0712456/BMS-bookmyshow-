package com.example.book_my_show.Repository;

import com.example.book_my_show.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
    Optional<Show> findById(int show_id);
}
