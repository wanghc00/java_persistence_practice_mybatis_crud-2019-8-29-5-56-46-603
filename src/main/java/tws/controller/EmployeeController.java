package tws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import tws.entity.Employee;
import tws.repository.EmployeeMapper;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }
    
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Employee getEmployee(@PathVariable int id) {
        return employeeMapper.getEmployee(id);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void addEmployee(@RequestBody Employee employee) {
        employeeMapper.addEmployee(employee);
    }
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void insertEmployee(@RequestBody Employee employee) {
        employeeMapper.insertEmployee(employee);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteEmployee(@PathVariable int id) {
        employeeMapper.deleteEmployee(id);
    }

}
