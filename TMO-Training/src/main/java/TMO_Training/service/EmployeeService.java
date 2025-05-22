package TMO_Training.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TMO_Training.exceptions.EmployeeNotFoundException;
import TMO_Training.model.Employee;
import TMO_Training.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
//	@Autowired
//    private EmployeeRepository repo;
	
	private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }
    
    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Employee getById(Long id) {
    	Employee existingEmp = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
        return repo.findById(id).orElse(null);
    }

    public Employee create(Employee e) {
        return repo.save(e);
    }

    public Employee update(Long id, Employee employee) {
    	Employee existingEmp = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));

        // Update fields explicitly
        existingEmp.setName(employee.getName());
        existingEmp.setDepartment(employee.getDepartment());
        existingEmp.setSalary(employee.getSalary());

        return repo.save(existingEmp);
    }

    public void delete(Long id) {
        Employee existingEmp = repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
        repo.deleteById(id);
    }
}
