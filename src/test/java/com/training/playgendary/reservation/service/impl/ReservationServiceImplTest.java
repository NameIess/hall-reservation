package com.training.playgendary.reservation.service.impl;

import com.training.playgendary.reservation.config.TestConfig;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.dto.request.SearchReservationDTO;
import com.training.playgendary.reservation.service.EmployeeService;
import com.training.playgendary.reservation.service.ReservationService;
import com.training.playgendary.reservation.service.RoomService;
import com.training.playgendary.reservation.service.exception.ServiceException;
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
public class ReservationServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoomService roomService;

    @DataProvider(name = "validEmployeeAndDateRange")
    public static Object[][] validEmployeeAndDateRange() throws ParseException {
        return new Object[][]{
                {TestResources.SEARCH_RESERVATION_EMPL_ID_1_FIND_1, 1},
                {TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_1, 1},
                {TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_2, 2},
        };
    }

    @DataProvider(name = "validEmployeeAndWrongDateRange")
    public static Object[][] validEmployeeAndWrongDateRange() throws ParseException {
        return new Object[][]{
                {TestResources.SEARCH_RESERVATION_EMPL_ID_1_FIND_0_WRONG_START_TIME, 0},
                {TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_0_WRONG_START_AND_END_TIME, 0},
                {TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_1_WRONG_END_TIME, 1},
        };
    }

    @DataProvider(name = "validEmployeeAndInvalidDateRange")
    public static Object[][] validEmployeeAndInvalidDateRange() throws ParseException {
        return new Object[][]{
                {TestResources.SEARCH_RESERVATION_EMPL_ID_1_FIND_0_INVALID_START_TIME},
                {TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_START_AND_END_TIME},
                {TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME},
        };
    }


    @Test
    public void shouldReturnReservationListWhenReservationTableExists() {
        List<Reservation> reservations = reservationService.findAll();
        int actualResult = reservations.size();

        Assert.assertEquals(actualResult, TestResources.TABLE_RESERVATION_ROWS_AMOUNT);
    }

    @Test(dataProvider = "validEmployeeAndDateRange")
    public void shouldReturnEmployeeReservationListWhenEmployeeValidAndDateRangeSatisfies(SearchReservationDTO searchReservationDTO, int expectedResult) throws ServiceException {
        List<Reservation> reservations = reservationService.findAllByEmployeeAndDateRange(searchReservationDTO);
        int actualResult = reservations.size();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "validEmployeeAndWrongDateRange")
    public void shouldReturnEmptyEmployeeReservationListWhenEmployeeValidAndDateRangeNotSatisfies(SearchReservationDTO searchReservationDTO, int expectedResult) throws ServiceException {
        List<Reservation> reservations = reservationService.findAllByEmployeeAndDateRange(searchReservationDTO);
        int actualResult = reservations.size();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(expectedExceptions = ServiceException.class, dataProvider = "validEmployeeAndInvalidDateRange")
    public void shouldThrowServiceExceptionWhenDateRangeInvalid(SearchReservationDTO searchReservationDTO) throws ServiceException {
        reservationService.findAllByEmployeeAndDateRange(searchReservationDTO);
    }

}
