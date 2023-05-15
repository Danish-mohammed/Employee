package com.bridgelabz.employeepayroll.empService;

import com.bridgelabz.employeepayroll.dto.EmpDTO;
import com.bridgelabz.employeepayroll.dto.ResponseDTO;
import com.bridgelabz.employeepayroll.exception.EmployeeCustomException;
import com.bridgelabz.employeepayroll.model.EmpData;
import com.bridgelabz.employeepayroll.repository.EmpRepo;
import com.bridgelabz.employeepayroll.util.EmailService;
import com.bridgelabz.employeepayroll.util.JWTTOken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class EmployeeServiceImp implements EmployeeService{

    List<EmpData> list= new ArrayList<>();

    @Autowired
    private JWTTOken jwttOken;

    @Autowired
    private EmailService employeeService;
    @Autowired
    private EmpRepo empRepo;
    @Override
    public ResponseDTO addEmployee(EmpDTO empDTO) {
        EmpData empData = new EmpData(empDTO);
        empRepo.save(empData);
        String token = jwttOken.createToken(empData.getEmp_id());
        employeeService.sendEmail(empDTO.getEmail(),"Data Added Successfully",
                 "Hai...."+empData.getName()+ "\n You have been successfully Added Data!\n\n"+ empData);
        return new ResponseDTO(token,empData);
    }

    @Override
    public EmpData getEmployeeById(String token) {
        int id = jwttOken.decodeToken(token);
        return empRepo.findById(id)
                .orElseThrow(() -> new EmployeeCustomException("Employee Not found with id: " +id));
    }

    @Override
    public List<EmpData> getAllEmployee() {
        return empRepo.findAll();
    }

    @Override
    public List<EmpData> getEmployeeByDept(String dept) {
        return empRepo.findEmployeeByDept(dept);
    }

}
