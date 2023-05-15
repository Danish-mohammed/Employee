package com.bridgelabz.employeepayroll.empService;

import com.bridgelabz.employeepayroll.dto.EmpDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.model.EmpData;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    ResponseDTO addEmployee(EmpDTO empDTO);

    EmpData getEmployeeById(String token);

    List<EmpData> getAllEmployee();

    List<EmpData> getEmployeeByDept(String dept);
}
