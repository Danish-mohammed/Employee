package com.bridgelabz.employeepayroll.repository;

import com.bridgelabz.employeepayroll.model.EmpData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpRepo extends JpaRepository<EmpData,Integer> {

    @Query(value = "select * from emp_data,emp_dept where emp_id=id and dept = :dept",nativeQuery = true)
    List<EmpData> findEmployeeByDept(String dept);
}
