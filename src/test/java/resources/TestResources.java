package resources;

import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.dto.request.SaveReservationDTO;
import com.training.playgendary.reservation.entity.dto.request.SearchReservationDTO;
import resources.exception.TestDataInitException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestResources {
    public static final int TABLE_RESERVATION_ROWS_AMOUNT = 12;
    public static final int TABLE_ROOM_ROWS_AMOUNT = 10;
    public static final int TABLE_EMPLOYEE_ROWS_AMOUNT = 11;
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT);

    public static final Employee VALID_EMPLOYEE_ID_1 = new Employee();
    static {
        VALID_EMPLOYEE_ID_1.setId(1L);
        VALID_EMPLOYEE_ID_1.setFirstName("Alex");
        VALID_EMPLOYEE_ID_1.setLastName("Nosko");
        VALID_EMPLOYEE_ID_1.setPersonalNumber("ANJD97");
    }

    public static final Employee VALID_EMPLOYEE_ID_2 = new Employee();
    static {
        VALID_EMPLOYEE_ID_2.setId(2L);
        VALID_EMPLOYEE_ID_2.setFirstName("Tinner");
        VALID_EMPLOYEE_ID_2.setLastName("Turner");
        VALID_EMPLOYEE_ID_2.setPersonalNumber("TTID98");
    }

    public static final Employee VALID_EMPLOYEE_ID_3 = new Employee();
    static {
        VALID_EMPLOYEE_ID_3.setId(3L);
        VALID_EMPLOYEE_ID_3.setFirstName("Scott");
        VALID_EMPLOYEE_ID_3.setLastName("Tiger");
        VALID_EMPLOYEE_ID_3.setPersonalNumber("STMD73");
    }

    public static final Employee VALID_EMPLOYEE_ID_4 = new Employee();
    static {
        VALID_EMPLOYEE_ID_4.setId(4L);
        VALID_EMPLOYEE_ID_4.setFirstName("John");
        VALID_EMPLOYEE_ID_4.setLastName("Smith");
        VALID_EMPLOYEE_ID_4.setPersonalNumber("JSSD64");
    }

    public static final List<Employee> EMPLOYEES = new ArrayList<>();
    static {
        EMPLOYEES.add(VALID_EMPLOYEE_ID_1);
        EMPLOYEES.add(VALID_EMPLOYEE_ID_2);
        EMPLOYEES.add(VALID_EMPLOYEE_ID_3);
        EMPLOYEES.add(VALID_EMPLOYEE_ID_4);
    }

    public static final Employee TEST_EMPLOYEE = new Employee();
    static {
        TEST_EMPLOYEE.setFirstName("TestEmployeeFirstName");
        TEST_EMPLOYEE.setLastName("TestEmployeeLastName");
        TEST_EMPLOYEE.setPersonalNumber("TEST_EMP");
    }

    public static final Employee INVALID_EMPLOYEE_ID_0 = new Employee();
    static {
        INVALID_EMPLOYEE_ID_0.setId(0L);
        INVALID_EMPLOYEE_ID_0.setFirstName("Mitch");
        INVALID_EMPLOYEE_ID_0.setLastName("Lucker");
        INVALID_EMPLOYEE_ID_0.setPersonalNumber("SS2012");
    }

    public static final Room VALID_ROOM_ID_1 = new Room();
    static {
        VALID_ROOM_ID_1.setId(1L);
        VALID_ROOM_ID_1.setNumber("A101");
        VALID_ROOM_ID_1.setCapacity(10);
        VALID_ROOM_ID_1.setDescription("Interview room");
    }

    public static final Room VALID_ROOM_ID_2 = new Room();
    static {
        VALID_ROOM_ID_2.setId(2L);
        VALID_ROOM_ID_2.setNumber("A102");
        VALID_ROOM_ID_2.setCapacity(10);
        VALID_ROOM_ID_2.setDescription("Interview room");
    }

    public static final Room VALID_ROOM_ID_3 = new Room();
    static {
        VALID_ROOM_ID_3.setId(3L);
        VALID_ROOM_ID_3.setNumber("A103");
        VALID_ROOM_ID_3.setCapacity(20);
        VALID_ROOM_ID_3.setDescription("Meeting room");
    }

    public static final Room TEST_ROOM = new Room();
    static {
        TEST_ROOM.setNumber("TEST100");
        TEST_ROOM.setCapacity(100);
        TEST_ROOM.setDescription("TEST ROOM");
    }

    public static final List<Room> ROOMS = new ArrayList<>();
    static {
        ROOMS.add(VALID_ROOM_ID_1);
        ROOMS.add(VALID_ROOM_ID_2);
        ROOMS.add(VALID_ROOM_ID_3);
    }

    public static final Reservation RESERVATION = new Reservation();
    static {
        try {
            RESERVATION.setId(1L);
            RESERVATION.setEmployee(VALID_EMPLOYEE_ID_1);
            RESERVATION.setRoom(VALID_ROOM_ID_3);
            Date startTime = DATE_FORMAT.parse("2018-01-18 10:00:00");
            RESERVATION.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-01-18 10:30:00");
            RESERVATION.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static RESERVATION initialization block: " + e.getMessage(), e);
        }
    }

    public static final List<Reservation> RESERVATIONS = new ArrayList<>();
    static {
        RESERVATIONS.add(RESERVATION);
    }

    public static final SearchReservationDTO SEARCH_RESERVATION_EMPL_ID_1_FIND_1;
    static {
        try {
            SEARCH_RESERVATION_EMPL_ID_1_FIND_1 = new SearchReservationDTO();
            SEARCH_RESERVATION_EMPL_ID_1_FIND_1.setEmployeeId(1L);
            Date startTime = DATE_FORMAT.parse("2018-01-18 10:00:00");
            SEARCH_RESERVATION_EMPL_ID_1_FIND_1.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-01-18 10:30:00");
            SEARCH_RESERVATION_EMPL_ID_1_FIND_1.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SEARCH_RESERVATION_EMPL_ID_1_FIND_1 initialization block: " + e.getMessage(), e);
        }
    }

    public static final SearchReservationDTO SEARCH_RESERVATION_EMPL_ID_3_FIND_1;
    static {
        try {
            SEARCH_RESERVATION_EMPL_ID_3_FIND_1 = new SearchReservationDTO();
            SEARCH_RESERVATION_EMPL_ID_3_FIND_1.setEmployeeId(3L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 14:00:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_1.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 15:00:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_1.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SEARCH_RESERVATION_EMPL_ID_3_FIND_1 initialization block: " + e.getMessage(), e);
        }
    }

    public static final SearchReservationDTO SEARCH_RESERVATION_EMPL_ID_3_FIND_2;
    static {
        try {
            SEARCH_RESERVATION_EMPL_ID_3_FIND_2 = new SearchReservationDTO();
            SEARCH_RESERVATION_EMPL_ID_3_FIND_2.setEmployeeId(3L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 14:00:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_2.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 15:30:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_2.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SEARCH_RESERVATION_EMPL_ID_3_FIND_2 initialization block: " + e.getMessage(), e);
        }
    }

    public static final SearchReservationDTO SEARCH_RESERVATION_EMPL_ID_1_FIND_0_WRONG_START_TIME;
    static {
        try {
            SEARCH_RESERVATION_EMPL_ID_1_FIND_0_WRONG_START_TIME = new SearchReservationDTO();
            SEARCH_RESERVATION_EMPL_ID_1_FIND_0_WRONG_START_TIME.setEmployeeId(1L);
            Date startTime = DATE_FORMAT.parse("2018-01-18 10:25:00");
            SEARCH_RESERVATION_EMPL_ID_1_FIND_0_WRONG_START_TIME.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-01-18 10:30:00");
            SEARCH_RESERVATION_EMPL_ID_1_FIND_0_WRONG_START_TIME.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SEARCH_RESERVATION_EMPL_ID_1_FIND_0_WRONG_START_TIME initialization block: " + e.getMessage(), e);
        }
    }

    public static final SearchReservationDTO SEARCH_RESERVATION_EMPL_ID_3_FIND_0_WRONG_START_AND_END_TIME;
    static {
        try {
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_WRONG_START_AND_END_TIME = new SearchReservationDTO();
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_WRONG_START_AND_END_TIME.setEmployeeId(3L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 10:00:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_WRONG_START_AND_END_TIME.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 12:10:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_WRONG_START_AND_END_TIME.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SEARCH_RESERVATION_EMPL_ID_3_FIND_0_WRONG_START_AND_END_TIME initialization block: " + e.getMessage(), e);
        }
    }

    public static final SearchReservationDTO SEARCH_RESERVATION_EMPL_ID_3_FIND_1_WRONG_END_TIME;
    static {
        try {
            SEARCH_RESERVATION_EMPL_ID_3_FIND_1_WRONG_END_TIME = new SearchReservationDTO();
            SEARCH_RESERVATION_EMPL_ID_3_FIND_1_WRONG_END_TIME.setEmployeeId(3L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 14:00:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_1_WRONG_END_TIME.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 15:20:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_1_WRONG_END_TIME.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SEARCH_RESERVATION_EMPL_ID_3_FIND_1_WRONG_END_TIME initialization block: " + e.getMessage(), e);
        }
    }

    public static final SearchReservationDTO SEARCH_RESERVATION_EMPL_ID_1_FIND_0_INVALID_START_TIME;
    static {
        try {
            SEARCH_RESERVATION_EMPL_ID_1_FIND_0_INVALID_START_TIME = new SearchReservationDTO();
            SEARCH_RESERVATION_EMPL_ID_1_FIND_0_INVALID_START_TIME.setEmployeeId(1L);
            Date startTime = DATE_FORMAT.parse("2018-01-18 10:31:00");
            SEARCH_RESERVATION_EMPL_ID_1_FIND_0_INVALID_START_TIME.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-01-18 10:30:00");
            SEARCH_RESERVATION_EMPL_ID_1_FIND_0_INVALID_START_TIME.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SEARCH_RESERVATION_EMPL_ID_1_FIND_0_WRONG_START_TIME initialization block: " + e.getMessage(), e);
        }
    }

    public static final SearchReservationDTO SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_START_AND_END_TIME;
    static {
        try {
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_START_AND_END_TIME = new SearchReservationDTO();
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_START_AND_END_TIME.setEmployeeId(3L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 09:59:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_START_AND_END_TIME.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 18:01:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_START_AND_END_TIME.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SEARCH_RESERVATION_EMPL_ID_3_FIND_0_WRONG_START_AND_END_TIME initialization block: " + e.getMessage(), e);
        }
    }

    public static final SearchReservationDTO SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME;
    static {
        try {
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME = new SearchReservationDTO();
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME.setEmployeeId(3L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 14:00:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 18:01:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME initialization block: " + e.getMessage(), e);
        }
    }

    public static final SaveReservationDTO SAVE_RESERVATION_INVALID_END_TIME;
    static {
        try {
            SAVE_RESERVATION_INVALID_END_TIME = new SaveReservationDTO();
            SAVE_RESERVATION_INVALID_END_TIME.setEmployeeId(1L);
            SAVE_RESERVATION_INVALID_END_TIME.setRoomId(1L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 14:00:00");
            SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 18:01:00");
            SAVE_RESERVATION_INVALID_END_TIME.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SAVE_RESERVATION_INVALID_END_TIME initialization block: " + e.getMessage(), e);
        }
    }

    public static final SaveReservationDTO SAVE_RESERVATION_INVALID_START_TIME;
    static {
        try {
            SAVE_RESERVATION_INVALID_START_TIME = new SaveReservationDTO();
            SAVE_RESERVATION_INVALID_START_TIME.setEmployeeId(1L);
            SAVE_RESERVATION_INVALID_START_TIME.setRoomId(1L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 09:59:00");
            SAVE_RESERVATION_INVALID_START_TIME.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 18:00:00");
            SAVE_RESERVATION_INVALID_START_TIME.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SAVE_RESERVATION_INVALID_START_TIME initialization block: " + e.getMessage(), e);
        }
    }

    public static final SaveReservationDTO SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME;
    static {
        try {
            SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME = new SaveReservationDTO();
            SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME.setEmployeeId(1L);
            SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME.setRoomId(1L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 09:59:00");
            SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 23:00:00");
            SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME initialization block: " + e.getMessage(), e);
        }
    }

    public static final SaveReservationDTO SAVE_RESERVATION_EMPL_ID_1_FIND_ROOM_1_ALREADY_RESERVED;
    static {
        try {
            SAVE_RESERVATION_EMPL_ID_1_FIND_ROOM_1_ALREADY_RESERVED = new SaveReservationDTO();
            SAVE_RESERVATION_EMPL_ID_1_FIND_ROOM_1_ALREADY_RESERVED.setEmployeeId(1L);
            SAVE_RESERVATION_EMPL_ID_1_FIND_ROOM_1_ALREADY_RESERVED.setRoomId(1L);
            Date startTime = DATE_FORMAT.parse("2018-01-18 10:00:00");
            SAVE_RESERVATION_EMPL_ID_1_FIND_ROOM_1_ALREADY_RESERVED.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-01-18 10:30:00");
            SAVE_RESERVATION_EMPL_ID_1_FIND_ROOM_1_ALREADY_RESERVED.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SAVE_RESERVATION_EMPL_ID_1_FIND_ROOM_1_ALREADY_RESERVED initialization block: " + e.getMessage(), e);
        }
    }

    public static final SaveReservationDTO SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_1_ALREADY_RESERVED;
    static {
        try {
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_1_ALREADY_RESERVED = new SaveReservationDTO();
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_1_ALREADY_RESERVED.setEmployeeId(3L);
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_1_ALREADY_RESERVED.setRoomId(1L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 14:00:00");
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_1_ALREADY_RESERVED.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 15:00:00");
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_1_ALREADY_RESERVED.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_1_ALREADY_RESERVED initialization block: " + e.getMessage(), e);
        }
    }

    public static final SaveReservationDTO SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_2_ALREADY_RESERVED;
    static {
        try {
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_2_ALREADY_RESERVED = new SaveReservationDTO();
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_2_ALREADY_RESERVED.setEmployeeId(3L);
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_2_ALREADY_RESERVED.setRoomId(2L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 14:00:00");
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_2_ALREADY_RESERVED.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 15:30:00");
            SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_2_ALREADY_RESERVED.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SAVE_RESERVATION_EMPL_ID_3_FIND_ROOM_2_ALREADY_RESERVED initialization block: " + e.getMessage(), e);
        }
    }

    public static final SaveReservationDTO SAVE_RESERVATION_VALID_1;
    static {
        try {
            SAVE_RESERVATION_VALID_1 = new SaveReservationDTO();
            SAVE_RESERVATION_VALID_1.setEmployeeId(1L);
            SAVE_RESERVATION_VALID_1.setRoomId(3L);
            Date startTime = DATE_FORMAT.parse("2018-01-18 10:25:00");
            SAVE_RESERVATION_VALID_1.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-01-18 10:30:00");
            SAVE_RESERVATION_VALID_1.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SAVE_RESERVATION_VALID_1 initialization block: " + e.getMessage(), e);
        }
    }

    public static final SaveReservationDTO SAVE_RESERVATION_VALID_2;
    static {
        try {
            SAVE_RESERVATION_VALID_2 = new SaveReservationDTO();
            SAVE_RESERVATION_VALID_2.setEmployeeId(3L);
            SAVE_RESERVATION_VALID_2.setRoomId(7L);
            Date startTime = DATE_FORMAT.parse("2018-04-18 10:00:00");
            SAVE_RESERVATION_VALID_2.setStartTime(startTime);
            Date endTime = DATE_FORMAT.parse("2018-04-18 12:10:00");
            SAVE_RESERVATION_VALID_2.setEndTime(endTime);
        } catch (ParseException e) {
            throw new TestDataInitException("Error within static SAVE_RESERVATION_VALID_2 initialization block: " + e.getMessage(), e);
        }
    }
}
