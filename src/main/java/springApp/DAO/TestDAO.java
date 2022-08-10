package springApp.DAO;

import springApp.Classes.Question;
import springApp.Classes.Test;

import java.util.Set;

public interface TestDAO extends GeneralDAO<Test>{

    Set<Question> findQuestionsByTId(int id);

}
