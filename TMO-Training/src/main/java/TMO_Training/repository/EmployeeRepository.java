package TMO_Training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import TMO_Training.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
