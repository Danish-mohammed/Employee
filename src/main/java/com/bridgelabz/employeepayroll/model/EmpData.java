package com.bridgelabz.employeepayroll.model;

import com.bridgelabz.employeepayroll.dto.EmpDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpData {
    @Id
    @GeneratedValue
    private int emp_id;
    private String name;
    private double salary;

    private String gender;
    private String profilePic;
    private LocalDate startDate;
    private String note;

    @ElementCollection
    @CollectionTable(name="Emp_dept", joinColumns = @JoinColumn(name="id"))
    private List<String> dept;

    public EmpData(EmpDTO empDTO) {
        this.name = empDTO.name;
        this.salary = empDTO.salary;
        this.gender = empDTO.gender;
        this.profilePic = empDTO.profilePic;
        this.note = empDTO.note;
        this.startDate = empDTO.startDate;
        this.dept = empDTO.dept;
    }

}
