package com.edteam.reservations.repository;

import com.edteam.reservations.model.Reservation;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationRepositoryTest {

    @Test
    void getReservation_should_return_the_information() {
        //Given
        ReservationRepository repository = new ReservationRepository();

        //WHen
        Optional<Reservation> result = repository.getReservationById(1L);

        //Then
        assertEquals(1L, result.get().getId());
    }

    @Test
    void getReservation_should_not_return_the_information() {
        //Given
        ReservationRepository repository = new ReservationRepository();

        //WHen
        Optional<Reservation> result = repository.getReservationById(1L);

        //Then
        assertTrue(result.isEmpty());
    }
}
