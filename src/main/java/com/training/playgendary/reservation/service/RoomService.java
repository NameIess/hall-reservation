package com.training.playgendary.reservation.service;

import com.training.playgendary.reservation.entity.Room;

import java.util.List;

/**
 * Contains the basic methods for interacting with the Room entity.
 */
public interface RoomService {

    /**
     * Saves the particular entity into data source.
     *
     * @param room Particular room entity to be saved.
     * @return Saved and identified room entity.
     */
    Room save(Room room);

    /**
     * Finds the room using the particular room @id.
     *
     * @param id Requested room identifier.
     * @return Room with particular @id value.
     */
    Room findById(Long id);

    /**
     * Finds all rooms that are stored in a data source.
     *
     * @return Room list.
     */
    List<Room> findAll();
}
