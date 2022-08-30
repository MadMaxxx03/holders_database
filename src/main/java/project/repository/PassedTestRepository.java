package project.repository;

import org.springframework.data.jpa.repository.Query;
import project.classes.PassedTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.classes.PassedTestShort;
import project.classes.QuestionShort;

import java.util.List;

@Repository
public interface PassedTestRepository extends JpaRepository<PassedTest, Integer> {

    @Query(value = "select new project.classes.PassedTestShort(pId, progress, holder.hId, test.tId) from PassedTest ")
    List<PassedTestShort> getPart();
}
