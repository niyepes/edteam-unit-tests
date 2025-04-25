import com.edteam.reservations.model.*;
import com.edteam.reservations.repository.ReservationRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationRepositoryTest {

    @Test
    void getReservation_should_return_the_information() {
        //Given
        ReservationRepository repository = new ReservationRepository();

        //When
        Optional<Reservation> result = repository.getReservationById(1L);

        //Then
        assertAll(
                () -> assertNotNull(result),
                () -> assertTrue(result.isPresent()),
                () -> assertEquals(getReservation(1L,"EZE","MIA"),result.get())
        );
    }

    @Test
    void getReservation_should_not_return_the_information() {
        //Given
        ReservationRepository repository = new ReservationRepository();

        //WHen
        Optional<Reservation> result = repository.getReservationById(6L);

        //Then
        assertTrue(result.isEmpty());
    }

    private Reservation getReservation (long id,String origin, String destination){
        Passenger passenger = new Passenger();
        passenger.setFirstName("Andres");
        passenger.setLastName("Sacco");
        passenger.setId(1L);
        passenger.setDocumentType("DNI");
        passenger.setDocumentNumber("12345678");
        passenger.setBirthday(LocalDate.of(1985, 1, 1));

        Price price = new Price();
        price.setBasePrice(BigDecimal.ONE);
        price.setTotalTax(BigDecimal.ZERO);
        price.setTotalPrice(BigDecimal.ONE);

        Segment segment = new Segment();
        segment.setArrival("2025-01-01");
        segment.setDeparture("2024-12-31");
        segment.setOrigin("EZE");
        segment.setDestination("MIA");
        segment.setCarrier("AA");
        segment.setId(1L);

        Itinerary itinerary = new Itinerary();
        itinerary.setId(1L);
        itinerary.setPrice(price);
        itinerary.setSegment(List.of(segment));

        Reservation reservation = new Reservation();
        reservation.setId(1L);
        reservation.setPassengers(List.of(passenger));
        reservation.setItinerary(itinerary);

        return reservation;
    }
}
