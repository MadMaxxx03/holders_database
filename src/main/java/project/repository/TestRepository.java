package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.classes.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}
