package aktar.Employee.Management.controller;

import aktar.Employee.Management.dto.EmployeeDto;
import aktar.Employee.Management.service.impl.EmployeeService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class EmployeeManagementController {
    private static final Logger logger= LoggerFactory.getLogger(EmployeeManagementController.class);

   private final EmployeeService employeeService;
   public EmployeeManagementController(EmployeeService employeeService){
       this.employeeService=employeeService;
   }

    @GetMapping("/greetings")
    public String greetings() {
        logger.info("welcome to employee management");
        return " hi kuhu";
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> getEmployeeDetails() {
        List<EmployeeDto> employeeDto = employeeService.getAllEmployee();
        return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDto> createEmployeeDetails(@Valid @RequestBody EmployeeDto employeeDto) {
        EmployeeDto employee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        logger.info("Request received to delete info of employee : {}",id);
        employeeService.deleteEmployee(id);
        return  ResponseEntity.ok().build();

    }

    @GetMapping("/employees/{emp_id}")
    public ResponseEntity<EmployeeDto> findByEmployeeId(@PathVariable Long emp_id){
        EmployeeDto employeeDto=employeeService.findByEmployeeId(emp_id);
        return ResponseEntity.ok().body(employeeDto);
    }

    @PostMapping("/employees/{emp_id}")
    public  ResponseEntity<EmployeeDto> updateEmployeeById(@PathVariable Long emp_id,@RequestBody EmployeeDto employeeDto){
       return ResponseEntity.ok(employeeService.updateByEmployeeId(emp_id,employeeDto));
    }


}
