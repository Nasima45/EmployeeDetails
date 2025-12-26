package aktar.Employee.Management.mapper;


import aktar.Employee.Management.dto.EmployeeDto;
import aktar.Employee.Management.entity.EmployeeEntity;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(EmployeeEntity employeeEntity){
        return new EmployeeDto(
                employeeEntity.getId(),
                employeeEntity.getFirstName(),
                employeeEntity.getLastName(),
                employeeEntity.getEmail()
        );
    }
    public static EmployeeEntity mapToEmployee(EmployeeDto employee){
        return new EmployeeEntity(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }
}
