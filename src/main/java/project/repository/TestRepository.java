package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.classes.QuestionShort;
import project.classes.Test;
import project.classes.TestShort;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    @Query(value = "select new project.classes.TestShort(tId, holder.hId) from Test ")
    List<TestShort> getPart();
}
