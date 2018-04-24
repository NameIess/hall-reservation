package com.training.playgendary.reservation.service;

import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.dto.request.SaveReservationDTO;
import com.training.playgendary.reservation.entity.dto.request.SearchReservationDTO;
import com.training.playgendary.reservation.service.exception.ServiceException;

import java.util.List;

public interface ReservationService {

    List<Reservation> findAll();

    Reservation save(SaveReservationDTO saveReservationDTO) throws ServiceException;

    List<Reservation> findAllByEmployeeAndDateRange(SearchReservationDTO searchReservationDTO) throws ServiceException;

}
