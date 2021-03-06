package com.training.playgendary.reservation.controller;

import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.dto.request.PageableDTO;
import com.training.playgendary.reservation.entity.dto.request.SaveReservationDTO;
import com.training.playgendary.reservation.entity.dto.request.SearchReservationDTO;
import com.training.playgendary.reservation.service.EmployeeService;
import com.training.playgendary.reservation.service.ReservationService;
import com.training.playgendary.reservation.service.RoomService;
import com.training.playgendary.reservation.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Controller that provides View layer with access to business logic operations.
 */

@RestController
@RequestMapping(value = "/conference")
public class ReservationController {
    private EmployeeService employeeService;
    private ReservationService reservationService;
    private RoomService roomService;

    @Autowired
    public ReservationController(EmployeeService employeeService, ReservationService reservationService, RoomService roomService) {
        this.employeeService = employeeService;
        this.reservationService = reservationService;
        this.roomService = roomService;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public Page<Employee> findAllEmployees(@RequestBody PageableDTO pageableDTO) {
        Page<Employee> employeePage = employeeService.findAll(pageableDTO);
        return employeePage;
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Employee findEmployee(@PathVariable("id") long id) {
        Employee employee = employeeService.findById(id);
        return employee;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        return savedEmployee;
    }

    @RequestMapping(value = "/room", method = RequestMethod.PUT)
    public Page<Room> findAllRooms(@RequestBody PageableDTO pageableDTO) {
        Page<Room> rooms = roomService.findAll(pageableDTO);
        return rooms;
    }

    @RequestMapping(value = "/room/{id}", method = RequestMethod.GET)
    public Room findRoom(@PathVariable("id") long id) {
        Room room = roomService.findById(id);
        return room;
    }

    @RequestMapping(value = "/room", method = RequestMethod.POST)
    public Room saveRoom(@Valid @RequestBody Room room) {
        Room savedRoom = roomService.save(room);
        return savedRoom;
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.PUT)
    public Page<Reservation> findAllReservations(@RequestBody PageableDTO pageableDTO) {
        Page<Reservation> reservations = reservationService.findAll(pageableDTO);
        return reservations;
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public Reservation findReservation(@PathVariable("id") long id) {
        Reservation reservation = reservationService.findById(id);
        return reservation;
    }

    @RequestMapping(value = "/reservation/employee", method = RequestMethod.GET)
    public List<Reservation> findAllEmployeeReservations(@Valid @RequestBody SearchReservationDTO searchReservationDTO) throws ServiceException {
        List<Reservation> reservations = reservationService.findAllByEmployeeAndDateRange(searchReservationDTO);
        return reservations;
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public Reservation saveReservation(@Valid @RequestBody SaveReservationDTO saveReservationDTO) throws ServiceException {
        Reservation savedReservation = reservationService.save(saveReservationDTO);
        return savedReservation;
    }
}