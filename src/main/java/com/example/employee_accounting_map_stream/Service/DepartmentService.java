package com.example.employee_accounting_map_stream.Service;

import com.example.employee_accounting_map_stream.dto.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {

    Employee findMaxSalaryInTheDep(int department);

    Employee findMinSalaryInTheDep(int department);

    Collection<Employee> findAllInfoDep(int department);

    Map<Integer, List<Employee>> getGroupingDep();
}
