package com.training.playgendary.reservation.entity.factory;

import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;

import java.util.Date;

/**
 * Contains a factory method to create an reservation instance.
 */
public interface ReservationFactory {

    Reservation create(Employee employee, Room room, Date startTime, Date endTime);
}
