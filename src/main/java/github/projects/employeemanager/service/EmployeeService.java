package github.projects.employeemanager.service;

import github.projects.employeemanager.exeption.UserNotFoundException;
import github.projects.employeemanager.model.Employee;
import github.projects.employeemanager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long idEmployee){
        return employeeRepository.findEmployeeById(idEmployee)
                .orElseThrow(() -> new UserNotFoundException("User by id " + idEmployee + " was no found."));
    }

    public void deleteEmployee(Long idEmployee){
        employeeRepository.deleteById(idEmployee);
    }
}
