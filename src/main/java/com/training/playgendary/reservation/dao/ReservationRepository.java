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

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqualAndEmployee(Date startTime, Date endTime, Employee employee);

    @Query("SELECT r " +
                "FROM Reservation r " +
                    "WHERE r.room = :room " +
                        "AND (r.startTime <= :startTime AND r.endTime >= :endTime " +
                        "OR r.startTime > :startTime AND r.startTime < :endTime " +
                        "OR r.endTime > :startTime AND r.endTime < :endTime) "
    )
    List<Reservation> findAllInStartTimeAndEndTimeRange(@Param("room") Room room, @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
