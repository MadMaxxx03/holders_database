package springApp.Repository;

import springApp.Classes.PassedTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassedTestRepository extends JpaRepository<PassedTest, Integer> {
}