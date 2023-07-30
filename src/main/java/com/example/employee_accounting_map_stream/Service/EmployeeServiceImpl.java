package com.example.employee_accounting_map_stream.Service;

import com.example.employee_accounting_map_stream.dto.Employee;
import com.example.employee_accounting_map_stream.exception.EmployeeAlreadyAddedException;
import com.example.employee_accounting_map_stream.exception.EmployeeNotFoundException;
import com.example.employee_accounting_map_stream.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final Map<String, Employee> employeeMap;
    private static final int MAX_EMPLOYEES = 100;

    public EmployeeServiceImpl() {
        employeeMap = new HashMap<>();

    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int department, double salary) {
        Employee newEmployee = new Employee(firstName, lastName, department, salary);

        if (employeeMap.size() < MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("превышен лимит количества сотрудников в фирме");
        }
        String key = firstName + lastName;
        if (employeeMap.containsKey(newEmployee)) {
            throw new EmployeeAlreadyAddedException("в коллекции уже есть такой сотрудник");
        }
        employeeMap.put(key, newEmployee);
        return newEmployee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.remove(firstName + lastName);
        if (!employeeMap.containsValue(employee)) {
            throw new EmployeeNotFoundException("сотрудник не найден");

        }
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = employeeMap.get(firstName + lastName);

        if (employeeMap.containsKey(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("сотрудник не найден");

    }

    @Override
    public Collection<Employee> printAll() {
        return employeeMap.values();
    }

}