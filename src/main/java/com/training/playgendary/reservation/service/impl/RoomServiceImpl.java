package com.training.playgendary.reservation.service.impl;

import com.training.playgendary.reservation.dao.RoomRepository;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.dto.request.assembler.PageableAssembler;
import com.training.playgendary.reservation.entity.dto.request.PageableDTO;
import com.training.playgendary.reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service("roomService")
@Transactional
public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository;
    private PageableAssembler pageableAssembler;

    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository, PageableAssembler pageableAssembler) {
        this.roomRepository = roomRepository;
        this.pageableAssembler = pageableAssembler;
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
    public Page<Room> findAll(PageableDTO pageableDTO) {
        Pageable pageable = pageableAssembler.createRequest(pageableDTO, Room.class);
        Page<Room> rooms = roomRepository.findAll(pageable);

        rooms.forEach(e -> {
            e.getReservations().size();
        });

        return rooms;
    }
}
