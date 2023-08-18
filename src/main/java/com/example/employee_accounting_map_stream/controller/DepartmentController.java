package com.example.employee_accounting_map_stream.controller;

import com.example.employee_accounting_map_stream.Service.DepartmentService;
import com.example.employee_accounting_map_stream.dto.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findMaxSalaryInTheDep(@RequestParam int departmentId) {
        return departmentService.findMaxSalaryInTheDep(departmentId);

    }

    @GetMapping("/min-salary")
    public Employee findMinSalaryInTheDep(@RequestParam int departmentId) {
        return departmentService.findMinSalaryInTheDep(departmentId);
    }

    @GetMapping("/all")
    public Collection<Employee> findAllInfoDep(int departmentId) {
        return departmentService.findAllInfoDep(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getGroupingDep() {
        return departmentService.getGroupingDep();
    }

}
