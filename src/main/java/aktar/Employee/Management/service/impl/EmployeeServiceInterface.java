package aktar.Employee.Management.service.impl;



import aktar.Employee.Management.dto.EmployeeDto;

import java.util.List;

public interface EmployeeServiceInterface {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAllEmployee();
    void deleteEmployee(Long id);
    EmployeeDto findByEmployeeId(Long id);
}
