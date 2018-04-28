package com.training.playgendary.reservation.service.impl.unit;

import com.training.playgendary.reservation.dao.ReservationRepository;
import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.factory.ReservationFactory;
import com.training.playgendary.reservation.service.EmployeeService;
import com.training.playgendary.reservation.service.ReservationService;
import com.training.playgendary.reservation.service.RoomService;
import com.training.playgendary.reservation.service.exception.ServiceException;
import com.training.playgendary.reservation.service.impl.ReservationServiceImpl;
import com.training.playgendary.reservation.service.validator.DateValidator;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;
import resources.TestResources;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;

public class ReservationServiceImplTestUnit {
    private ReservationService underTest;
    private ReservationRepository reservationRepository;
    private EmployeeService employeeService;
    private RoomService roomService;
    private DateValidator dateValidator;
    private ReservationFactory reservationFactory;

    @Before
    public void doSetup() {
        reservationRepository = mock(ReservationRepository.class);
        employeeService = mock(EmployeeService.class);
        roomService = mock(RoomService.class);
        dateValidator = mock(DateValidator.class);
        reservationFactory = mock(ReservationFactory.class);
        underTest = new ReservationServiceImpl(reservationRepository, employeeService, roomService, dateValidator, reservationFactory);
    }

    @Test
    public void shouldReturnReservationListWhenReservationTableExists() {
        List<Reservation> expectedResult = TestResources.RESERVATIONS;
        when(underTest.findAll()).thenReturn(expectedResult);

        List<Reservation> actualResult = underTest.findAll();

        verify(reservationRepository, times(1)).findAll();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(expected = ServiceException.class)
    public void shouldThrowServiceExceptionWhenDatesToSaveHaveInvalidFormat() throws ServiceException {
        when(employeeService.findById(anyLong())).thenReturn(TestResources.VALID_EMPLOYEE_ID_1);
        when(roomService.findById(anyLong())).thenReturn(TestResources.VALID_ROOM_ID_1);
        when(dateValidator.isValid(any(Date.class), any(Date.class))).thenReturn(false);

        underTest.save(TestResources.SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME);
    }

    @Test(expected = ServiceException.class)
    public void shouldThrowServiceExceptionWhenDatesHaveAlreadyReserved() throws ServiceException {
        when(employeeService.findById(anyLong())).thenReturn(TestResources.VALID_EMPLOYEE_ID_1);
        when(roomService.findById(anyLong())).thenReturn(TestResources.VALID_ROOM_ID_1);
        when(dateValidator.isValid(any(Date.class), any(Date.class))).thenReturn(true);
        when(reservationRepository.findAllInStartTimeAndEndTimeRange(any(Room.class), any(Date.class), any(Date.class))).thenReturn(TestResources.RESERVATIONS);

        underTest.save(TestResources.SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME);
    }

    @Test
    public void shouldSaveReservationAndReturnSavedEntityWhenDataValid() throws ServiceException {
        when(employeeService.findById(anyLong())).thenReturn(TestResources.VALID_EMPLOYEE_ID_1);
        when(roomService.findById(anyLong())).thenReturn(TestResources.VALID_ROOM_ID_1);
        when(dateValidator.isValid(any(Date.class), any(Date.class))).thenReturn(true);
        when(reservationRepository.findAllInStartTimeAndEndTimeRange(any(Room.class), any(Date.class), any(Date.class))).thenReturn(new ArrayList<>());
        Reservation expectedResult = TestResources.RESERVATION;
        when(reservationFactory.create(any(Employee.class), any(Room.class), any(Date.class), any(Date.class))).thenReturn(expectedResult);
        when(reservationRepository.save(expectedResult)).thenReturn(expectedResult);

        Reservation actualResult = underTest.save(TestResources.SAVE_RESERVATION_INVALID_START_TIME_AND_END_TIME);

        verify(employeeService, times(1)).findById(anyLong());
        verify(roomService, times(1)).findById(anyLong());
        verify(dateValidator, times(1)).isValid(any(Date.class), any(Date.class));
        verify(reservationRepository, times(1)).findAllInStartTimeAndEndTimeRange(any(Room.class), any(Date.class), any(Date.class));
        verify(reservationRepository, times(1)).save(any(Reservation.class));

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(expected = ServiceException.class)
    public void shouldThrowServiceExceptionWhenDatesToSearchHaveInvalidFormat() throws ServiceException {
        when(employeeService.findById(anyLong())).thenReturn(TestResources.VALID_EMPLOYEE_ID_1);
        when(dateValidator.isValid(any(Date.class), any(Date.class))).thenReturn(false);

        underTest.findAllByEmployeeAndDateRange(TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME);
    }

    @Test(expected = ServiceException.class)
    public void shouldFindEmployeeReservationAndReturnReservationListWhenDataValid() throws ServiceException {
        when(employeeService.findById(anyLong())).thenReturn(TestResources.VALID_EMPLOYEE_ID_1);
        when(dateValidator.isValid(any(Date.class), any(Date.class))).thenReturn(false);
        List<Reservation> expectedResult = TestResources.RESERVATIONS;
        when(reservationRepository.findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqualAndEmployee(any(Date.class), any(Date.class), any(Employee.class))).thenReturn(expectedResult);

        List<Reservation> actualResult = underTest.findAllByEmployeeAndDateRange(TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_0_INVALID_END_TIME);

        verify(employeeService, times(1)).findById(anyLong());
        verify(dateValidator, times(1)).isValid(any(Date.class), any(Date.class));
        verify(reservationRepository, times(1)).findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqualAndEmployee(any(Date.class), any(Date.class), any(Employee.class));

        Assert.assertEquals(actualResult, expectedResult);
    }
}
