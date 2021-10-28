package com.spring.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;

@Entity
@Table(name="program")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long programCode;
    private String programName;
    private String duration;
    private double fee;

    public void setId(Long id) {
        this.id = id;
    }

    public void setProgramCode(Long programCode) {
        this.programCode = programCode;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public Long getProgramCode() {
        return programCode;
    }

    public String getProgramName() {
        return programName;
    }

    public String getDuration() {
        return duration;
    }

    public double getFee() {
        return fee;
    }


}