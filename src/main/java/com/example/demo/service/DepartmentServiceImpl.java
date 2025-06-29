package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long id){
        return departmentRepository.findById(id).get();
    }

    @Override
    public void deleteDepartmentById(Long id){
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department){
        Department debDB = departmentRepository.findById(departmentId).get();
        if(Objects.nonNull(department.getDepartmentName())&&!"".equalsIgnoreCase(department.getDepartmentName())){
                debDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode())&&!"".equalsIgnoreCase(department.getDepartmentCode())){
            debDB.setDepartmentCode(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress())&&!"".equalsIgnoreCase(department.getDepartmentAddress())){
            debDB.setDepartmentAddress(department.getDepartmentName());
        }

        return departmentRepository.save(debDB);
    }

    public Department getDepartmentByName(String departmentName){
        return departmentRepository.getDepartmentByDepartmentName(departmentName);
    }
}
