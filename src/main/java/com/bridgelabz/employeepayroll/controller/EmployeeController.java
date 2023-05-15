package com.bridgelabz.employeepayroll.controller;

import com.bridgelabz.employeepayroll.dto.EmpDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.empService.EmployeeService;
import com.bridgelabz.employeepayroll.model.EmpData;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseDTO> addEmployee(@Valid @RequestBody EmpDTO empDTO){
//        String token = employeeService.addEmployee(empDTO);
//        ResponseDTO responseDTO = employeeService.addEmployee(empDTO);
        return new ResponseEntity<>(employeeService.addEmployee(empDTO), HttpStatus.CREATED);
    }

    @GetMapping("/getByToken")
    public ResponseDTO getEmployeeById(@RequestHeader String token){
        EmpData empData = employeeService.getEmployeeById(token);
        ResponseDTO responseDTO = new ResponseDTO("Employee Data Found",empData);
        return responseDTO;
    }

    @GetMapping("/")
    public ResponseDTO getAllEmployee(){
        List<EmpData> empData = employeeService.getAllEmployee();
        ResponseDTO responseDTO = new ResponseDTO("Employee Data Found",empData);
        return responseDTO;
    }

    @GetMapping("/getbydept/{dept}")
    public ResponseDTO getEmployeeByDept(@PathVariable String dept){
        List<EmpData> empData = employeeService.getEmployeeByDept(dept);
        ResponseDTO responseDTO = new ResponseDTO("Employee Data Found",empData);
        return responseDTO;
    }
}
