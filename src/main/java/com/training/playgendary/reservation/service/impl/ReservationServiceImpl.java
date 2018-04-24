package com.training.playgendary.reservation.service.impl;

import com.training.playgendary.reservation.dao.ReservationRepository;
import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.dto.request.SaveReservationDTO;
import com.training.playgendary.reservation.entity.dto.request.SearchReservationDTO;
import com.training.playgendary.reservation.service.EmployeeService;
import com.training.playgendary.reservation.service.ReservationService;
import com.training.playgendary.reservation.service.RoomService;
import com.training.playgendary.reservation.service.exception.ServiceException;
import com.training.playgendary.reservation.service.validator.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("reservationService")
@Repository
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private EmployeeService employeeService;
    private RoomService roomService;
    private DateValidator dateValidator;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, EmployeeService employeeService, RoomService roomService, DateValidator dateValidator) {
        this.reservationRepository = reservationRepository;
        this.employeeService = employeeService;
        this.roomService = roomService;
        this.dateValidator = dateValidator;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

    //  Refactor
    @Override
    public Reservation save(SaveReservationDTO saveReservationDTO) throws ServiceException {

        Long employeeId = saveReservationDTO.getEmployeeId();
        Employee employee = employeeService.findById(employeeId);
        Long roomId = saveReservationDTO.getRoomId();
        Room room = roomService.findById(roomId);
        Date startTime = saveReservationDTO.getStartTime();
        Date endTime = saveReservationDTO.getEndTime();

        boolean isDatesValid = dateValidator.isValid(startTime, endTime);
        if (!isDatesValid) {
            throw new ServiceException("Dates are not valid");
        }

        List<Reservation> reservationList = reservationRepository.findAllInStartTimeAndEndTimeRange(room, startTime, endTime);
        boolean isReservationAvailable = reservationList.isEmpty();
        if (!isReservationAvailable) {
            throw new ServiceException("Reservation is not available for following time: from " + startTime + " till " + endTime);
        }

        Reservation reservation = new Reservation();
        reservation.setStartTime(startTime);
        reservation.setEndTime(endTime);
        employee.addReservation(reservation);
        room.addReservation(reservation);

        Reservation savedReservation = reservationRepository.save(reservation);
        return savedReservation;
    }

    //  Refactor
    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findAllByEmployeeAndDateRange(SearchReservationDTO searchReservationDTO) throws ServiceException {

        Long employeeId = searchReservationDTO.getEmployeeId();
        Employee employee = employeeService.findById(employeeId);
        Date startTime = searchReservationDTO.getStartTime();
        Date endTime = searchReservationDTO.getEndTime();

        if (dateValidator.isValid(startTime, endTime)) {
            List<Reservation> employeeReservations = reservationRepository.findAllByStartTimeGreaterThanEqualAndEndTimeLessThanEqualAndEmployee(startTime, endTime, employee);
            return employeeReservations;
        } else {
            throw new ServiceException("Dates are not valid");
        }
    }
}
