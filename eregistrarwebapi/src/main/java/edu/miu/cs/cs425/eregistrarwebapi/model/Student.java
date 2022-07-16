package edu.miu.cs.cs425.eregistrarwebapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    private Long studentId;

    @NotBlank(message = "Student Number cannot be null or empty or blank spaces")
    // @Column(name = "student_number", unique = true, nullable = false)
    private String studentNumber;

    @NotBlank(message = "First Name cannot be null or empty or blank spaces")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last Name cannot be null or empty or blank spaces")
    private String lastName;

    private double cgpa;

    @NotNull(message = "Enrollment Date cannot be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate enrollmentDate;

    @NotNull(message = "is International cannot be null")
    private boolean isInternational;

    public boolean isIsInternational() {
        return isInternational;
    }

    /**
     * @param isInternational the isInternational to set
     */
    public void setIsInternational(boolean isInternational) {
        this.isInternational = isInternational;
    }
}
