package com.training.playgendary.reservation.service.impl;

import com.training.playgendary.reservation.dao.ReservationRepository;
import com.training.playgendary.reservation.entity.Employee;
import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.Room;
import com.training.playgendary.reservation.entity.dto.request.SaveReservationDTO;
import com.training.playgendary.reservation.entity.dto.request.SearchReservationDTO;
import com.training.playgendary.reservation.entity.factory.ReservationFactory;
import com.training.playgendary.reservation.service.EmployeeService;
import com.training.playgendary.reservation.service.ReservationService;
import com.training.playgendary.reservation.service.RoomService;
import com.training.playgendary.reservation.service.exception.ServiceException;
import com.training.playgendary.reservation.service.validator.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("reservationService")
@Transactional
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private EmployeeService employeeService;
    private RoomService roomService;
    private DateValidator dateValidator;
    private ReservationFactory reservationFactory;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, EmployeeService employeeService, RoomService roomService, DateValidator dateValidator, ReservationFactory reservationFactory) {
        this.reservationRepository = reservationRepository;
        this.employeeService = employeeService;
        this.roomService = roomService;
        this.dateValidator = dateValidator;
        this.reservationFactory = reservationFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reservation> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

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
            throw new ServiceException("Trouble within save: dates are not valid");
        }

        List<Reservation> reservationList = reservationRepository.findAllInStartTimeAndEndTimeRange(room, startTime, endTime);
        boolean isReservationAvailable = reservationList.isEmpty();
        if (!isReservationAvailable) {
            throw new ServiceException("Reservation is not available for following time: from " + startTime + " till " + endTime);
        }

        Reservation reservation = reservationFactory.create(employee, room, startTime, endTime);
        Reservation savedReservation = reservationRepository.save(reservation);

        return savedReservation;
    }

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
        }

        throw new ServiceException("Trouble within findAllByEmployeeAndDateRange: dates are not valid");
    }

    @Override
    public Reservation findById(Long id) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(id);

        Reservation reservation = null;

        if (optionalReservation.isPresent()) {
            reservation = optionalReservation.get();
        }

        return reservation;
    }
}
