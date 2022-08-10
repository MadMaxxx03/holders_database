package springApp.Repository;

import springApp.Classes.Question;
import springApp.Classes.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

    @Query("select Test.questions from Test where Test.tId =: id")
    Set<Question> findQuestionsByTId(int id);
}
