package com.turdiev.SpringREST.controller;

import com.turdiev.SpringREST.entity.Employee;
import com.turdiev.SpringREST.exception_handing.EmployeeIncorrectData;
import com.turdiev.SpringREST.exception_handing.NoSuchEmployeeException;
import com.turdiev.SpringREST.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List <Employee> showAllEmployee (){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;

    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee (@PathVariable int id ){

        Employee employee = employeeService.getEmployee(id);

        if(employee==null){

            throw new NoSuchEmployeeException("There is no employee with ID = " + id + " int Database");
        }

        return employee;

    }


    @PostMapping("/employees")
    public Employee addNewEmployee (@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee (@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee employee = employeeService.getEmployee(id);


        if(employee==null){
            throw  new NoSuchEmployeeException("There is no employee with ID = " + id + " int Database");
        }

        employeeService.deleteEmployee(id);

        return "Employee with id " + id + " was delete";
    }


}
