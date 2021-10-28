package com.spring.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="enrollment")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long programCode;
    private String programName;
    private LocalDate startDate;
    private double amountPaid;
    private String status;

    public String getProgramName() {
        return programName;
    }

    public Long getId() {
        return id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public Long getProgramCode() {
        return programCode;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public void setProgramCode(Long programCode) {
        this.programCode = programCode;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Enrollment(Long customerId, Long programCode,String programName, LocalDate startDate, double amountPaid, String status) {
        this.customerId = customerId;
        this.programCode = programCode;
        this.startDate = startDate;
        this.amountPaid = amountPaid;
        this.status = status;
        this.programName=programName;
    }
    public Enrollment(){}
}
