package com.example.book_my_show.Repository;

import com.example.book_my_show.models.Show;
import com.example.book_my_show.models.ShowSeat;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
    Optional<ShowSeat> findById(int showseat_id);
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    List<ShowSeat> findShowSeatByIdInAndSeatStatus_AvailableAndShow(List<Integer> show_seat_id, Show show);
//    SELECT * FROM ShowSeat
//    WHERE show_seat_id IN (1, 2, 3, ...) -- Replace 1, 2, 3, ... with the actual IDs in your list
//    AND seat_status = 'Available'
//    AND show_id = <show_id>; -- Replace <show_id> with the ID of the specific show;

}
