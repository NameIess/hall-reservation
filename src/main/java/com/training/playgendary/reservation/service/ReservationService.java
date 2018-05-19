package com.training.playgendary.reservation.service;

import com.training.playgendary.reservation.entity.Reservation;
import com.training.playgendary.reservation.entity.dto.request.PageableDTO;
import com.training.playgendary.reservation.entity.dto.request.SaveReservationDTO;
import com.training.playgendary.reservation.entity.dto.request.SearchReservationDTO;
import com.training.playgendary.reservation.service.exception.ServiceException;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Contains the basic methods for interacting with the Reservation entity.
 */
public interface ReservationService {

    /**
     * Finds all reservations that are stored in data source.
     *
     * @return Reservation list.
     */
    Page<Reservation> findAll(PageableDTO pageableDTO);

    /**
     * Validates and saves particular entity into data source.
     *
     * @param saveReservationDTO Data-transfer object that contains the information about the entity to be stored.
     * @return Saved and identified reservation entity.
     *
     * @throws ServiceException Exception to be thrown if the @saveReservationDTO data is not valid.
     */
    Reservation save(SaveReservationDTO saveReservationDTO) throws ServiceException;

    /**
     * Finds all reservations that are stored in data source and satisfy requirements stored within @searchReservationDTO.
     *
     * @param searchReservationDTO Data-transfer object that contains the information about the entity to be found.
     * @return Reservation list that satisfy requirements stored within @searchReservationDTO.
     *
     * @throws ServiceException Exception to be thrown if the @searchReservationDTO data is not valid.
     */
    List<Reservation> findAllByEmployeeAndDateRange(SearchReservationDTO searchReservationDTO) throws ServiceException;

    /**
     * Finds the reservation using particular reservation @id.
     * @param id Requested reservation identifier.
     * @return Reservation with particular @id value.
     */
    Reservation findById(Long id);
}
