package com.tn.repository;

import com.tn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("FROM Employee ")
    List<Employee> getAllData();

    @Query("FROM Employee WHERE age > 35")
    List<Employee> getEmployeeAgeGreaterThanThirtyFive();

    @Modifying
    @Query("UPDATE Employee SET age = 500 WHERE id = :id")
    void updateEmployeeById(@Param("id") Integer id);

    @Modifying
    @Query("DELETE FROM Employee WHERE id = :id")
    void deleteEmployeeById(@Param("id") Integer id);

    @Query("FROM Employee WHERE fullname = :fullName and age > :age")
    List<Employee> getEmployeeByFullNameAndAge(@Param("fullName") String fullName,
                                     @Param("age") Integer age);
}
