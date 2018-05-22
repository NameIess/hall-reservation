package com.training.playgendary.reservation.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Employee")
public class Employee implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String personalNumber;
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
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    @NotNull
    @Size(min = 1, max = 150, message = "error.employee.nameSize")
    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    @NotNull
    @Size(min = 1, max = 255, message = "error.employee.personalNumberSize")
    @Column(name = "personal_number")
    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personal_number) {
        this.personalNumber = personal_number;
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
        if (this == o) {
            return true;
        }

        if (!(o instanceof Employee)) {
            return false;
        }

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) {
            return false;
        }

        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) {
            return false;
        }

        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) {
            return false;
        }

        return personalNumber != null ? personalNumber.equals(employee.personalNumber) : employee.personalNumber == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (personalNumber != null ? personalNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", personalNumber='").append(personalNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
