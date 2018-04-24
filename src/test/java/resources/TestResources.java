package resources;

import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.dto.request.SearchReservationDTO;
import resources.exception.TestDataInitException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestResources {
    public static final int TABLE_RESERVATION_ROWS_AMOUNT = 12;
    public static final int TABLE_ROOM_ROWS_AMOUNT = 10;
    public static final int TABLE_EMPLOYEE_ROWS_AMOUNT = 11;
    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final DateFormat DATE_FORMAT = new SimpleDateFormat(DATE_TIME_FORMAT);

    public static final Employee VALID_EMPLOYEE_ID_1 = new Employee();
    static {
        VALID_EMPLOYEE_ID_1.setId(1L);
        VALID_EMPLOYEE_ID_1.setFirst_name("Alex");
        VALID_EMPLOYEE_ID_1.setLast_name("Nosko");
        VALID_EMPLOYEE_ID_1.setPersonal_number("ANJD97");
    }

    public static final Employee VALID_EMPLOYEE_ID_2 = new Employee();
    static {
        VALID_EMPLOYEE_ID_2.setId(2L);
        VALID_EMPLOYEE_ID_2.setFirst_name("Tinner");
        VALID_EMPLOYEE_ID_2.setLast_name("Turner");
        VALID_EMPLOYEE_ID_2.setPersonal_number("TTID98");
    }

    public static final Employee VALID_EMPLOYEE_ID_3 = new Employee();
    static {
        VALID_EMPLOYEE_ID_3.setId(3L);
        VALID_EMPLOYEE_ID_3.setFirst_name("Scott");
        VALID_EMPLOYEE_ID_3.setLast_name("Tiger");
        VALID_EMPLOYEE_ID_3.setPersonal_number("STMD73");
    }

    public static final Employee VALID_EMPLOYEE_ID_4 = new Employee();
    static {
        VALID_EMPLOYEE_ID_4.setId(4L);
        VALID_EMPLOYEE_ID_4.setFirst_name("John");
        VALID_EMPLOYEE_ID_4.setLast_name("Smith");
        VALID_EMPLOYEE_ID_4.setPersonal_number("JSSD64");
    }

    public static final Employee TEST_EMPLOYEE = new Employee();
    static {
        TEST_EMPLOYEE.setFirst_name("TestEmployeeFirstName");
        TEST_EMPLOYEE.setLast_name("TestEmployeeLastName");
        TEST_EMPLOYEE.setPersonal_number("TEST_EMP");
    }

    public static final Employee INVALID_EMPLOYEE_ID_0 = new Employee();
    static {
        INVALID_EMPLOYEE_ID_0.setId(0L);
        INVALID_EMPLOYEE_ID_0.setFirst_name("Mitch");
        INVALID_EMPLOYEE_ID_0.setLast_name("Lucker");
        INVALID_EMPLOYEE_ID_0.setPersonal_number("SS2012");
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
}
