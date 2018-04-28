package com.training.playgendary.reservation.service.impl.unit;

import com.training.playgendary.reservation.dao.RoomRepository;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.service.RoomService;
import com.training.playgendary.reservation.service.impl.RoomServiceImpl;
import org.junit.Before;
import org.junit.Test;
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

    @Before
    public void doSetup() {
        roomRepository = mock(RoomRepository.class);
        underTest = new RoomServiceImpl(roomRepository);
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
        when(underTest.save(any(Room.class))).thenReturn(expectedResult);

        Room actualResult = underTest.save(expectedResult);

        verify(roomRepository, times(1)).save(any(Room.class));
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void shouldReturnRoomListWhenRoomTableExists() {
        List<Room> expectedResult = TestResources.ROOMS;
        when(underTest.findAll()).thenReturn(expectedResult);

        List<Room> actualResult = underTest.findAll();

        verify(roomRepository, times(1)).findAll();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
