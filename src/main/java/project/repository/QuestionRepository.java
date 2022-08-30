package project.repository;

import org.springframework.data.jpa.repository.Query;
import project.classes.HolderShort;
import project.classes.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.classes.QuestionShort;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query(value = "select new project.classes.QuestionShort(qId, question, answer, score, test.tId) from Question ")
    List<QuestionShort> getPart();
}
