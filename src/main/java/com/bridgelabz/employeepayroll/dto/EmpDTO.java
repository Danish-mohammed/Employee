package com.bridgelabz.employeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@ToString
@Data
public class EmpDTO {
    @NotNull
    @Pattern(regexp = "^[A-Z]{1}[A-Za-z]{2,}$",message = "Name is Invalid e.g(Axxxxx)")
    public String name;

    @Min(value=500,message = "Min Salary should be more then 500")
    @NotNull
    public double salary;

    private String email;

    @Pattern(regexp = "male|female", message = "Gender needs to be either male or female")
    public String gender;

    @NotBlank(message = "Profile Pic should not be empty")
    public String profilePic;

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate startDate;

    @NotBlank(message = "Note should not be empty")
    public String note;
    @NotEmpty(message = "Department should not be empty")
    public List<String>  dept;
}
