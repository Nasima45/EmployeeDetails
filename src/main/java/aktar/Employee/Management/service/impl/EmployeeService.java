package aktar.Employee.Management.service.impl;


import aktar.Employee.Management.dto.EmployeeDto;
import aktar.Employee.Management.entity.EmployeeEntity;
import aktar.Employee.Management.exception.EmployeeNotFoundException;
import aktar.Employee.Management.mapper.EmployeeMapper;
import aktar.Employee.Management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        EmployeeEntity employeeEntity = EmployeeMapper.mapToEmployee(employeeDto);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return EmployeeMapper.mapToEmployeeDto(savedEmployeeEntity);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<EmployeeEntity> employeeEntity = employeeRepository.findAll();
        if (employeeEntity.isEmpty()) {
            throw new EmployeeNotFoundException("No employees found ");
        }
        return employeeEntity.stream().map(EmployeeMapper::mapToEmployeeDto).toList();
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() ->
                new EmployeeNotFoundException("Employee not present in DB"));
        employeeRepository.deleteById(id);

    }

    @Override
    public EmployeeDto findByEmployeeId(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee not present in DB"));

        return EmployeeMapper.mapToEmployeeDto(employeeEntity);


    }
    public  EmployeeDto updateByEmployeeId(Long id,EmployeeDto employeeDto){
        EmployeeEntity employeeEntity=employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee not present in DB"));
        employeeEntity.setFirstName(employeeDto.getFirstName());
        employeeEntity.setLastName(employeeDto.getLastName());
        employeeEntity.setEmail(employeeDto.getEmail());
        return EmployeeMapper.mapToEmployeeDto(employeeEntity);

    }
}
