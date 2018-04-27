package com.training.playgendary.reservation.dao;

import com.training.playgendary.reservation.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Contains the basic methods for interacting with the room entity
 */
@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
