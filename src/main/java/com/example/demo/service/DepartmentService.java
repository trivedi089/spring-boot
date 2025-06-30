package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long id);

   public Department updateDepartment(Long departmentId, Department department);

   public Department getDepartmentByName(String departmentName);
}
