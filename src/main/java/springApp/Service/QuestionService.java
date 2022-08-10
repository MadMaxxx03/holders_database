package springApp.Service;

import springApp.Classes.Question;
import springApp.DAO.QuestionDAO;
import springApp.Repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionService implements QuestionDAO {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void save(Question obj) {
        questionRepository.save(obj);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }



    @Override
    public void update(Question obj) {

    }

    @Override
    public void delete(Question obj) {
        questionRepository.delete(obj);
    }
}
