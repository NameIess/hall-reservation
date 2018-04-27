package com.training.playgendary.reservation.dao;

import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Contains the basic methods for interacting with the reservation entity
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    /**
     * Selects data from the reservation table in between @startTime and @endTime including borders for the particular @employee
     * @param startTime Date value equals the beginning of the search range.
     * @param endTime   Date value equals the end of the search range.
     * @param employee  Particular employee who reserved any room from @startTime till @endTime
     * @return  List of reservation entities that satisfy aforementioned parameters.
     */
    List<Reservation> findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqualAndEmployee(Date startTime, Date endTime, Employee employee);

    /**
     * Selects data from the reservation table that satisfy two of the following requirements:
     *  1) the reservation room must be equal the @room
     *  2) the reservation start_time and the end_time must satisfy one of the following requirements
     *      2-1) the @startTime and the @endTime must be into reservation start_time and the end_time range including borders
     *      2-2) the reservation start_time must be in between the @startTime and the @endTime
     *      2-3) the reservation end_time must be in between the @startTime and the @endTime
     * @param room Particular room that was reserved from @startTime till @endTime
     * @param startTime Date value equals the beginning of the search range for start_time.
     * @param endTime   Date value equals the end of the search range for end_time.
     * @return  List of reservation entities that satisfy aforementioned parameters.
     */
    @Query("SELECT r " +
                "FROM Reservation r " +
                    "WHERE r.room = :room " +
                        "AND (r.startTime <= :startTime AND r.endTime >= :endTime " +
                        "OR r.startTime > :startTime AND r.startTime < :endTime " +
                        "OR r.endTime > :startTime AND r.endTime < :endTime) "
    )
    List<Reservation> findAllInStartTimeAndEndTimeRange(@Param("room") Room room, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
