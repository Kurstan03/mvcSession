package peaksoft.entity;

import jakarta.persistence.*;
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
    private String name;
    private String country;
    @Column()
    private String image;

    public Company(String name, String country, String image) {
        this.name = name;
        this.country = country;
        this.image = image;
    }
}
