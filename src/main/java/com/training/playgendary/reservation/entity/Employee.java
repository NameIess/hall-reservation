package com.training.playgendary.reservation.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity class for the Employee table mapping
 */
@Entity
@Table(name = "Employee")
public class Employee implements Serializable {
    private Long id;
    private String first_name;
    private String last_name;
    private String personal_number;
    private Set<Reservation> reservations = new HashSet<>();

    public Employee() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @NotNull
    @Size(min = 1, max = 150, message = "error.employee.nameSize")
    @Column(name = "first_name")
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    @NotNull
    @Size(min = 1, max = 150, message = "error.employee.nameSize")
    @Column(name = "last_name")
    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @NotNull
    @Size(min = 1, max = 255, message = "error.employee.personalNumberSize")
    @Column(name = "personal_number")
    public String getPersonal_number() {
        return personal_number;
    }

    public void setPersonal_number(String personal_number) {
        this.personal_number = personal_number;
    }

    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        reservation.setEmployee(this);
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (first_name != null ? !first_name.equals(employee.first_name) : employee.first_name != null) return false;
        if (last_name != null ? !last_name.equals(employee.last_name) : employee.last_name != null) return false;
        return personal_number != null ? personal_number.equals(employee.personal_number) : employee.personal_number == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (first_name != null ? first_name.hashCode() : 0);
        result = 31 * result + (last_name != null ? last_name.hashCode() : 0);
        result = 31 * result + (personal_number != null ? personal_number.hashCode() : 0);
        return result;
    }
}
