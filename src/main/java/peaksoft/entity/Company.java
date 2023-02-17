package peaksoft.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * @author kurstan
 * @created at 15.02.2023 11:47
 */
@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
public class Company {
    @Id
    @SequenceGenerator(
            name = "company_id_generator",
            sequenceName = "company_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_id_generator"
    )
    private Long id;
    @NotEmpty(message = "Name not should be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!")
    private String name;
    @Column(length = 100000)
    private String image;
    @NotEmpty(message = "Email should not be empty!")
    @Email(message = "Email should be valid!")
    private String email;
//    @Column(name = "count_employees")
//    @Min(value = 0, message = "Employees should be greater than 0!")
//    private int countEmployees;

    public Company(String name, String image, String email) {
        this.name = name;
        this.image = image;
        this.email = email;
    }
}
