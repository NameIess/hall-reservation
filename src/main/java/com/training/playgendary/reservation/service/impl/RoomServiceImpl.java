package com.training.playgendary.reservation.service.impl;

import com.training.playgendary.reservation.dao.RoomRepository;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("roomService")
@Repository
@Transactional
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room save(Room room) {
        Room savedRoom = roomRepository.save(room);
        return savedRoom;
    }

    @Override
    @Transactional(readOnly = true)
    public Room findById(Long id) {
        Optional<Room> optionalRoom = roomRepository.findById(id);

        Room room = null;

        if (optionalRoom.isPresent()) {
            room = optionalRoom.get();
        }

        return room;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Room> findAll() {
        List<Room> rooms = roomRepository.findAll();
        return rooms;
    }
}
