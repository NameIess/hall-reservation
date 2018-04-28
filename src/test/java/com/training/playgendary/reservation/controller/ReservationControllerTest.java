package com.training.playgendary.reservation.controller;

import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.dto.request.SaveReservationDTO;
import com.training.playgendary.reservation.entity.dto.request.SearchReservationDTO;
import com.training.playgendary.reservation.service.EmployeeService;
import com.training.playgendary.reservation.service.ReservationService;
import com.training.playgendary.reservation.service.RoomService;
import com.training.playgendary.reservation.service.exception.ServiceException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import resources.TestResources;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ReservationControllerTest {
    private ReservationController underTest;
    private EmployeeService employeeService;
    private RoomService roomService;
    private ReservationService reservationService;

    @Before
    public void doSetup() {
        employeeService = mock(EmployeeService.class);
        roomService = mock(RoomService.class);
        reservationService = mock(ReservationService.class);
        underTest = new ReservationController(employeeService, reservationService, roomService);
    }

    @Test
    public void shouldReturnRoomListWhenDataExist() {
        when(roomService.findAll()).thenReturn(TestResources.ROOMS);

        List<Room> actualResult = underTest.findAllRooms();
        verify(roomService, times(1)).findAll();

        Assert.assertEquals(actualResult, TestResources.ROOMS);
    }

    @Test
    public void shouldReturnEmployeeListWhenDataExist() {
        when(employeeService.findAll()).thenReturn(TestResources.EMPLOYEES);

        List<Employee> actualResult = underTest.findAllEmployees();
        verify(employeeService, times(1)).findAll();

        Assert.assertEquals(actualResult, TestResources.EMPLOYEES);
    }

    @Test
    public void shouldReturnReservationListWhenDataExist() {
        when(reservationService.findAll()).thenReturn(TestResources.RESERVATIONS);

        List<Reservation> actualResult = underTest.findAllReservations();
        verify(reservationService, times(1)).findAll();

        Assert.assertEquals(actualResult, TestResources.RESERVATIONS);
    }

    @Test(expected = ServiceException.class)
    public void shouldThrowServiceExceptionWhenSaveInvalidData() throws ServiceException {
        when(reservationService.save(any(SaveReservationDTO.class))).thenThrow(ServiceException.class);

        underTest.saveReservation(TestResources.SAVE_RESERVATION_INVALID_END_TIME);
    }

    @Test(expected = ServiceException.class)
    public void shouldThrowServiceExceptionWhenSearchByInvalidData() throws ServiceException {
        when(reservationService.findAllByEmployeeAndDateRange(any(SearchReservationDTO.class))).thenThrow(ServiceException.class);

        underTest.findAllEmployeeReservations(TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_2);
    }

    @Test
    public void shouldSaveRoomAndReturnSavedObjectWhenDataValid() {
        Room expectedResult = TestResources.VALID_ROOM_ID_1;
        when(roomService.save(any(Room.class))).thenReturn(expectedResult);

        Room actualResult = underTest.saveRoom(expectedResult);
        verify(roomService, times(1)).save((any(Room.class)));

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void shouldSaveEmployeeAndReturnSavedObjectWhenDataValid() {
        Employee expectedResult = TestResources.VALID_EMPLOYEE_ID_1;
        when(employeeService.save(any(Employee.class))).thenReturn(expectedResult);

        Employee actualResult = underTest.saveEmployee(expectedResult);
        verify(employeeService, times(1)).save((any(Employee.class)));

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void shouldSaveReservationAndReturnSavedObjectWhenDataValid() throws ServiceException {
        when(reservationService.save(any(SaveReservationDTO.class))).thenReturn(TestResources.RESERVATION);

        Reservation actualResult = underTest.saveReservation(TestResources.SAVE_RESERVATION_VALID_1);
        verify(reservationService, times(1)).save((any(SaveReservationDTO.class)));

        Assert.assertEquals(actualResult, TestResources.RESERVATION);
    }

    @Test
    public void shouldFindEmployeeReservationsWhenSearchDataValid() throws ServiceException {
        when(reservationService.findAllByEmployeeAndDateRange(any(SearchReservationDTO.class))).thenReturn(TestResources.RESERVATIONS);

        List<Reservation> actualResult = underTest.findAllEmployeeReservations(TestResources.SEARCH_RESERVATION_EMPL_ID_3_FIND_2);
        verify(reservationService, times(1)).findAllByEmployeeAndDateRange((any(SearchReservationDTO.class)));

        Assert.assertEquals(actualResult, TestResources.RESERVATIONS);
    }
}
