package com.training.playgendary.reservation.service.impl.unit;

import com.training.playgendary.reservation.dao.RoomRepository;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.dto.request.PageableAssembler;
import com.training.playgendary.reservation.entity.dto.request.PageableDTO;
import com.training.playgendary.reservation.service.RoomService;
import com.training.playgendary.reservation.service.impl.RoomServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.domain.PageImpl;
import org.testng.Assert;
import resources.TestResources;

import java.util.List;
import java.util.Optional;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.*;

public class RoomServiceImplTestUnit {
    private RoomService underTest;
    private RoomRepository roomRepository;
    private PageableAssembler pageableAssembler;

    @Before
    public void doSetup() {
        roomRepository = mock(RoomRepository.class);
        pageableAssembler = mock(PageableAssembler.class);
        underTest = new RoomServiceImpl(roomRepository, pageableAssembler);
    }

    @Test
    public void shouldReturnRoomWhenIdValid() {
        Room expectedResult = TestResources.VALID_ROOM_ID_1;
        when(roomRepository.findById(anyLong())).thenReturn(Optional.ofNullable(expectedResult));

        Room actualResult = underTest.findById(1L);

        verify(roomRepository, times(1)).findById(anyLong());
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void shouldSaveRoomAndReturnSavedEntityWhenRoomValid() {
        Room expectedResult = TestResources.VALID_ROOM_ID_1;
        when(roomRepository.save(any(Room.class))).thenReturn(expectedResult);

        Room actualResult = underTest.save(expectedResult);

        verify(roomRepository, times(1)).save(any(Room.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void shouldReturnRoomListWhenRoomTableExists() {
        List<Room> expectedResult = TestResources.ROOMS;
        when(pageableAssembler.createRequest(any(PageableDTO.class), any(Class.class))).thenReturn(TestResources.UNSORTED_REQUEST);
        when(roomRepository.findAll(TestResources.UNSORTED_REQUEST)).thenReturn(new PageImpl<>(expectedResult));

        List<Room> actualResult = underTest.findAll(new PageableDTO()).getContent();

        verify(roomRepository, times(1)).findAll(TestResources.UNSORTED_REQUEST);
        Assert.assertEquals(actualResult, expectedResult);
    }
}
