package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.DepartmentServiceImpl;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        //DepartmentService service = new DepartmentServiceImpl();
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long id){
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long id){
        departmentService.deleteDepartmentById(id);
        return " Department id : "+id+" deleted successfully";
    }

    @PutMapping("/departments/id/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId,department);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }
}
