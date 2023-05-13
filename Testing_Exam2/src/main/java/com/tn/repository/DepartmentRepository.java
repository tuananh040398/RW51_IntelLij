package com.tn.repository;

import com.tn.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    @Query("SELECT department FROM Department department WHERE concat(department.name, ' ', department.totalMember, ' ', department.type) LIKE %?1%")
    public List<Department> search(String keyword);
}
