package edu.miu.cs.cs425.eregistrarwebapi.repository;

import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByOrderByFirstNameAsc();

    // Custom query
    @Query(value = "SELECT * FROM students s WHERE s.first_name LIKE %:keyword%", nativeQuery = true)
    List<Student> findByKeyword(@Param("keyword") String keyword);
}
