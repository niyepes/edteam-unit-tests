package com.edteam.reservations.repository;

import com.edteam.reservations.model.Reservation;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReservationRepositoryTest {

    @Test
    void my_first_test() {
        ReservationRepository repository = new ReservationRepository();
        Optional<Reservation> result = repository.getReservationById(1L);
        assertEquals(1L, result.get().getId());
    }
}
