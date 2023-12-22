package com.cloud.learn.springboot.departmentservice.resource;

import com.cloud.learn.springboot.departmentservice.entity.Department;
import com.cloud.learn.springboot.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentResource {

    private DepartmentRepository departmentRepository;

    public DepartmentResource(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentRepository.findAll();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartment(@PathVariable Integer id){
        return departmentRepository.findById(id).get();
    }

    @PostMapping("/departments")
    public List<Department> createDepartments(@RequestBody List<Department> departments){

        return departmentRepository.saveAll(departments);

    }




}
