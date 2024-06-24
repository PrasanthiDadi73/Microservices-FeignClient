package employeeservice_of.controller;

import employeeservice_of.entity.Employee;
import employeeservice_of.feignclient.AddressClient;
import employeeservice_of.response.EmployeeResponse;
import employeeservice_of.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressClient addressClient;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findEmployees();
    }

    @GetMapping("/employees/{id}")
    private ResponseEntity<EmployeeResponse> getEmployeeDetails(@PathVariable("id") int id) {
        EmployeeResponse employee = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employee);
    }

}
