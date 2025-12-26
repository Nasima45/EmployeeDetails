package aktar.Employee.Management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="employee_details")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="email_id", nullable = false,unique = true)
    private String email;
    public EmployeeEntity() {}
    public EmployeeEntity(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

}
