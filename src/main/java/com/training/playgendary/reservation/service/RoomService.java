package com.training.playgendary.reservation.service;

import com.training.playgendary.reservation.entity.Room;

import java.util.List;

public interface RoomService {

    Room save(Room room);

    Room findById(Long id);

    List<Room> findAll();
}
