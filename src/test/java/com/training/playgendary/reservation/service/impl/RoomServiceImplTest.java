package com.training.playgendary.reservation.service.impl;

import com.training.playgendary.reservation.config.TestConfig;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.TestResources;

import java.text.ParseException;
import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class RoomServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private RoomService roomService;

    @DataProvider(name = "validRoomAndId")
    public static Object[][] validRoomAndId() throws ParseException {
        return new Object[][]{
                {1L, TestResources.VALID_ROOM_ID_1},
                {2L, TestResources.VALID_ROOM_ID_2},
                {3L, TestResources.VALID_ROOM_ID_3}
        };
    }


    @Test(dataProvider = "validRoomAndId")
    public void shouldReturnRoomWhenIdValid(Long id, Room expectedResult) {
        Room actualResult = roomService.findById(id);

        Assert.assertEquals(actualResult, expectedResult);
    }


    @Test
    public void shouldSaveRoomAndReturnSavedEntityWhenRoomValid() {
        Room actualResult = roomService.save(TestResources.TEST_ROOM);

        Assert.assertEquals(actualResult, TestResources.TEST_ROOM);
    }

    @Test
    public void shouldReturnRoomListWhenRoomTableExists() {
        List<Room> rooms = roomService.findAll();
        int actualResult = rooms.size();

        Assert.assertEquals(actualResult, TestResources.TABLE_ROOM_ROWS_AMOUNT);
    }
}
