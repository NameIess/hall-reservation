//package com.training.playgendary.reservation.controller;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.training.playgendary.reservation.config.TestConfig;
//import com.training.playgendary.reservation.entity.Employee;
//import com.training.playgendary.reservation.entity.Reservation;
//import com.training.playgendary.reservation.entity.Room;
//import com.training.playgendary.reservation.service.EmployeeService;
//import com.training.playgendary.reservation.service.ReservationService;
//import com.training.playgendary.reservation.service.RoomService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.testng.annotations.Test;
//
//import java.util.Date;
//import java.util.List;
//
//@WebAppConfiguration
//@ContextConfiguration(classes = TestConfig.class)
//@ActiveProfiles("test")
//public class ReservationControllerIT extends AbstractTestNGSpringContextTests {
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @Autowired
//    private RoomService roomService;
//
//    @Autowired
//    private ReservationService reservationService;
//
//    @Autowired
//    private ReservationController reservationController;
//
//
//    @Test
//    public void shouldReturnRoomListWhenDataExist() {
//        List<Reservation> reservations = reservationController.findAllReservations();
//
//        for (Reservation reservation : reservations) {
//            System.out.println("RS: " + reservation);
//        }
//    }
//}
