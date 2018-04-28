package com.training.playgendary.reservation.entity.factory.impl;

import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.factory.ReservationFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component("reservationFactory")
public class ReservationFactoryImpl implements ReservationFactory {

    @Override
    public Reservation create(Employee employee, Room room, Date startTime, Date endTime) {
        Reservation reservation = new Reservation();
        reservation.setStartTime(startTime);
        reservation.setEndTime(endTime);
        employee.addReservation(reservation);
        room.addReservation(reservation);

        return reservation;
    }
}
