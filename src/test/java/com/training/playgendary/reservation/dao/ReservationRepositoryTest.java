package com.training.playgendary.reservation.dao;

import com.training.playgendary.reservation.config.TestConfig;
import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import resources.TestResources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
@ActiveProfiles("test")
public class ReservationRepositoryTest extends AbstractTestNGSpringContextTests {

    private static DateFormat dateFormat;

    @Autowired
    private ReservationRepository underTest;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void test() {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(1, 7, sort);

        Page<Employee> employees = employeeRepository.findAll(pageable);
        List<Employee> content = employees.getContent();
        System.out.println("CNT: " + content);

    }

    @DataProvider(name = "validEmployeeAndDates")
    public static Object[][] validEmployeeAndDates() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 10:00:00"), dateFormat.parse("2018-01-18 10:30:00"), TestResources.VALID_EMPLOYEE_ID_1, 1},
                {dateFormat.parse("2018-05-18 14:00:00"), dateFormat.parse("2018-05-18 17:30:00"), TestResources.VALID_EMPLOYEE_ID_2, 1},
                {dateFormat.parse("2018-04-18 14:00:00"), dateFormat.parse("2018-04-18 15:00:00"), TestResources.VALID_EMPLOYEE_ID_3, 1},
                {dateFormat.parse("2018-04-18 15:30:00"), dateFormat.parse("2018-04-18 16:00:00"), TestResources.VALID_EMPLOYEE_ID_4, 1}
        };
    }

    @DataProvider(name = "invalidEmployeeAndAnyDates")
    public static Object[][] invalidEmployeeAndAnyDates() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 10:00:00"), dateFormat.parse("2018-01-18 10:30:00"), TestResources.INVALID_EMPLOYEE_ID_0, 0},
                {dateFormat.parse("2018-05-18 14:00:00"), dateFormat.parse("2018-05-18 17:30:00"), TestResources.INVALID_EMPLOYEE_ID_0, 0},
                {dateFormat.parse("2018-04-18 14:00:00"), dateFormat.parse("2018-04-18 15:00:00"), TestResources.INVALID_EMPLOYEE_ID_0, 0},
                {dateFormat.parse("2018-04-18 15:30:00"), dateFormat.parse("2018-04-18 16:00:00"), TestResources.INVALID_EMPLOYEE_ID_0, 0},
                {dateFormat.parse("2015-01-18 10:00:00"), dateFormat.parse("2019-01-18 10:30:00"), TestResources.INVALID_EMPLOYEE_ID_0, 0}
        };
    }

    @DataProvider(name = "validEmployeeAndStartTimeIsOutOfRange")
    public static Object[][] validEmployeeAndEndTimeAndStartTimeIsOutOfRange() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 10:20:00"), dateFormat.parse("2018-01-18 10:30:00"), TestResources.VALID_EMPLOYEE_ID_1, 0},
                {dateFormat.parse("2018-05-18 14:01:00"), dateFormat.parse("2018-05-18 17:30:00"), TestResources.VALID_EMPLOYEE_ID_2, 0},
                {dateFormat.parse("2018-04-18 14:59:00"), dateFormat.parse("2018-04-18 15:00:00"), TestResources.VALID_EMPLOYEE_ID_3, 0},
                {dateFormat.parse("2018-04-18 15:45:00"), dateFormat.parse("2018-04-18 16:00:00"), TestResources.VALID_EMPLOYEE_ID_4, 0}
        };
    }

    @DataProvider(name = "validEmployeeAndEndTimeIsOutOfRange")
    public static Object[][] validEmployeeAndStartTimeAndEndTimeIsOutOfRange() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 10:00:00"), dateFormat.parse("2018-01-18 10:50:00"), TestResources.VALID_EMPLOYEE_ID_1, 1},
                {dateFormat.parse("2018-05-18 14:00:00"), dateFormat.parse("2018-05-18 17:50:00"), TestResources.VALID_EMPLOYEE_ID_2, 1},
                {dateFormat.parse("2018-04-18 14:00:00"), dateFormat.parse("2018-04-18 15:50:00"), TestResources.VALID_EMPLOYEE_ID_3, 2},
                {dateFormat.parse("2018-04-18 15:30:00"), dateFormat.parse("2018-04-18 16:50:00"), TestResources.VALID_EMPLOYEE_ID_4, 1}
        };
    }

    @DataProvider(name = "validEmployeeAndStartTimeAndEndTimeFrameReservedRange")
    public static Object[][] validEmployeeAndStartTimeAndEndTimeFrameRangeAlreadyReserved() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 10:00:00"), dateFormat.parse("2018-01-18 10:50:00"), TestResources.VALID_EMPLOYEE_ID_1, 1},
                {dateFormat.parse("2018-05-18 14:00:00"), dateFormat.parse("2018-05-18 17:50:00"), TestResources.VALID_EMPLOYEE_ID_2, 1},
                {dateFormat.parse("2018-04-18 14:00:00"), dateFormat.parse("2018-04-18 15:50:00"), TestResources.VALID_EMPLOYEE_ID_3, 2},
                {dateFormat.parse("2018-04-18 15:30:00"), dateFormat.parse("2018-04-18 16:50:00"), TestResources.VALID_EMPLOYEE_ID_4, 1}
        };
    }

    @DataProvider(name = "twoDatesInRangeAlreadyReserved")
    public static Object[][] validRoomAndStartTimeAndEndTimeInRangeAlreadyReserved() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 10:01:00"), dateFormat.parse("2018-01-18 10:29:59"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-05-18 14:01:00"), dateFormat.parse("2018-05-18 20:59:59"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-04-18 14:30:00"), dateFormat.parse("2018-04-18 14:31:00"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-04-18 15:30:00"), dateFormat.parse("2018-04-18 16:00:00"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-04-18 15:25:00"), dateFormat.parse("2018-04-18 15:29:00"), TestResources.VALID_ROOM_ID_2, 1},
                {dateFormat.parse("2018-04-18 15:29:00"), dateFormat.parse("2018-04-18 15:30:00"), TestResources.VALID_ROOM_ID_2, 1}
        };
    }

    @DataProvider(name = "startTimeInRangeAlreadyReservedEndTimeIsValid")
    public static Object[][] validRoomAndStartTimeInRangeAlreadyReservedAndEndTimeOutOfRangeAlreadyReserved() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 10:01:00"), dateFormat.parse("2018-01-18 10:31:00"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-05-18 14:20:00"), dateFormat.parse("2018-05-18 17:50:00"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-04-18 14:59:00"), dateFormat.parse("2018-04-18 15:20:00"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-04-18 16:00:00"), dateFormat.parse("2018-04-18 18:10:00"), TestResources.VALID_ROOM_ID_1, 1},
        };
    }

    @DataProvider(name = "startTimeIsValidEndTimeInRangeAlreadyReserved")
    public static Object[][] validRoomAndStartTimeOutOfRangeAlreadyReservedAndEndTimeInRangeAlreadyReserved() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 9:00:00"), dateFormat.parse("2018-01-18 10:01:00"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-05-18 13:59:00"), dateFormat.parse("2018-05-18 17:29:00"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-04-18 10:00:00"), dateFormat.parse("2018-04-18 18:30:00"), TestResources.VALID_ROOM_ID_1, 3},
                {dateFormat.parse("2018-04-18 13:30:00"), dateFormat.parse("2018-04-18 14:40:00"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2018-04-19 10:00:00"), dateFormat.parse("2018-04-19 11:59:00"), TestResources.VALID_ROOM_ID_3, 1}
        };
    }

    @DataProvider(name = "startTimeAndEndTimeFrameReservedRange")
    public static Object[][] validRoomAndStartTimeAndEndTimeOutOfRangeAlreadyReserved() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-01-18 9:00:00"), dateFormat.parse("2018-01-18 10:31:00"), TestResources.VALID_ROOM_ID_1, 1},
                {dateFormat.parse("2015-01-18 9:00:00"), dateFormat.parse("2020-01-18 15:01:00"), TestResources.VALID_ROOM_ID_1, 5},
                {dateFormat.parse("2018-04-18 10:00:00"), dateFormat.parse("2018-04-18 17:00:00"), TestResources.VALID_ROOM_ID_1, 3},
                {dateFormat.parse("2018-04-18 16:59:00"), dateFormat.parse("2018-04-18 18:01:00"), TestResources.VALID_ROOM_ID_2, 1},
                {dateFormat.parse("2018-04-19 10:00:00"), dateFormat.parse("2018-04-19 18:00:00"), TestResources.VALID_ROOM_ID_3, 2}
        };
    }

    @DataProvider(name = "startTimeAndEndTimeFree")
    public static Object[][] validRoomAndStartTimeAndEndTimeFree() throws ParseException {
        return new Object[][]{
                {dateFormat.parse("2018-04-20 12:00:00"), dateFormat.parse("2018-04-20 13:00:00"), TestResources.VALID_ROOM_ID_1, 0},
                {dateFormat.parse("2018-04-20 13:00:00"), dateFormat.parse("2018-04-20 14:00:00"), TestResources.VALID_ROOM_ID_2, 0},
                {dateFormat.parse("2018-05-18 17:30:00"), dateFormat.parse("2018-05-18 18:00:00"), TestResources.VALID_ROOM_ID_3, 0},
                {dateFormat.parse("2018-06-11 15:30:00"), dateFormat.parse("2018-06-11 15:50:00"), TestResources.VALID_ROOM_ID_1, 0},
                {dateFormat.parse("2018-07-03 12:25:00"), dateFormat.parse("2018-07-03 17:00:00"), TestResources.VALID_ROOM_ID_2, 0},
                {dateFormat.parse("2018-04-06 10:30:00"), dateFormat.parse("2018-04-06 11:00:00"), TestResources.VALID_ROOM_ID_3, 0},
                {dateFormat.parse("2018-01-18 10:00:00"), dateFormat.parse("2018-01-18 10:30:00"), TestResources.VALID_ROOM_ID_3, 0},
                {dateFormat.parse("2018-04-18 13:00:00"), dateFormat.parse("2018-04-18 18:00:00"), TestResources.VALID_ROOM_ID_3, 0}
        };
    }

    @BeforeSuite
    public void doSetup() {
        dateFormat = new SimpleDateFormat(TestResources.DATE_TIME_FORMAT);
    }

    private void verifyReservationSearchByRoomAndDates(Date startTime, Date endTime, Room room, int expectedReservationAmount) {
        List<Reservation> reservations = underTest.findAllInStartTimeAndEndTimeRange(room, startTime, endTime);

        Assert.assertNotNull(reservations);

        int actualReservationAmount = reservations.size();
        Assert.assertEquals(expectedReservationAmount, actualReservationAmount);
    }

    private void verifyReservationSearchByEmployeeAndDates(Date startTime, Date endTime, Employee employee, int expectedAmount) {
        List<Reservation> employeeReservations = underTest.findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqualAndEmployee(startTime, endTime, employee);

        Assert.assertNotNull(employeeReservations);

        int actualSize = employeeReservations.size();
        Assert.assertEquals(expectedAmount, actualSize);
    }

    @Test
    public void shouldReturnReservationListWhenTableExists() throws ParseException {
        List<Reservation> reservations = underTest.findAll();

        Assert.assertNotNull(reservations);

        int actualAmount = reservations.size();
        Assert.assertEquals(TestResources.TABLE_RESERVATION_ROWS_AMOUNT, actualAmount);
    }

    @Test(dataProvider = "validEmployeeAndDates")
    public void shouldReturnReservationListWhenStartTimeAndEndTimeInRangeAndEmployeeExists(Date startTime, Date endTime, Employee employee, int expectedAmount) throws ParseException {
        verifyReservationSearchByEmployeeAndDates(startTime, endTime, employee, expectedAmount);
    }

    @Test(dataProvider = "invalidEmployeeAndAnyDates")
    public void shouldReturnEmptyReservationListWhenEmployeeNotExists(Date startTime, Date endTime, Employee employee, int expectedAmount) throws ParseException {
        verifyReservationSearchByEmployeeAndDates(startTime, endTime, employee, expectedAmount);
    }

    @Test(dataProvider = "validEmployeeAndStartTimeIsOutOfRange")
    public void shouldReturnEmptyReservationListWhenEmployeeExistsAndStartTimeInvalid(Date startTime, Date endTime, Employee employee, int expectedAmount) throws ParseException {
        verifyReservationSearchByEmployeeAndDates(startTime, endTime, employee, expectedAmount);
    }

    @Test(dataProvider = "validEmployeeAndEndTimeIsOutOfRange")
    public void shouldReturnReservationListWhenEmployeeAndStartTimeValidAndEndTimeIsOutOfRangeAlreadyReserved(Date startTime, Date endTime, Employee employee, int expectedAmount) {
        verifyReservationSearchByEmployeeAndDates(startTime, endTime, employee, expectedAmount);
    }

    @Test(dataProvider = "validEmployeeAndStartTimeAndEndTimeFrameReservedRange")
    public void shouldReturnReservationListWhenEmployeeValidAndStartTimeAndEndTimeFrameRangeAlreadyReserved(Date startTime, Date endTime, Employee employee, int expectedAmount) {
        verifyReservationSearchByEmployeeAndDates(startTime, endTime, employee, expectedAmount);
    }

    @Test(dataProvider = "twoDatesInRangeAlreadyReserved")
    public void shouldReturnReservationListWhenEmployeeExistsAndStartTimeAndEndTimeInRangeAlreadyReserved(Date startTime, Date endTime, Room room, int expectedReservationAmount) {
        verifyReservationSearchByRoomAndDates(startTime, endTime, room, expectedReservationAmount);
    }

    @Test(dataProvider = "startTimeInRangeAlreadyReservedEndTimeIsValid")
    public void shouldReturnReservationListWhenEmployeeExistsAndStartTimeInRangeAlreadyReservedAndEndTimeOutOfRangeAlreadyReserved(Date startTime, Date endTime, Room room, int expectedReservationAmount) {
        verifyReservationSearchByRoomAndDates(startTime, endTime, room, expectedReservationAmount);
    }

    @Test(dataProvider = "startTimeIsValidEndTimeInRangeAlreadyReserved")
    public void shouldReturnReservationListWhenEmployeeExistsAndStartTimeOutOfRangeAlreadyReservedEndTimeInRangeAlreadyReservedAnd(Date startTime, Date endTime, Room room, int expectedReservationAmount) {
        verifyReservationSearchByRoomAndDates(startTime, endTime, room, expectedReservationAmount);
    }

    @Test(dataProvider = "startTimeAndEndTimeFrameReservedRange")
    public void shouldReturnReservationListWhenRoomExistsAndStartTimeAndEndTimeOutOfRangeAlreadyReserved(Date startTime, Date endTime, Room room, int expectedReservationAmount) {
        verifyReservationSearchByRoomAndDates(startTime, endTime, room, expectedReservationAmount);
    }

    @Test(dataProvider = "startTimeAndEndTimeFree")
    public void shouldReturnEmptyReservationListWhenReservationNotExists(Date startTime, Date endTime, Room room, int expectedReservationAmount) {
        verifyReservationSearchByRoomAndDates(startTime, endTime, room, expectedReservationAmount);
    }
}
