package springApp.Service;

import springApp.Classes.Question;
import springApp.Classes.Test;
import springApp.DAO.TestDAO;
import springApp.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TestService implements TestDAO {

    @Autowired
    private TestRepository testRepository;

    @Override
    public void save(Test obj) {
        testRepository.save(obj);
    }

    @Override
    public List<Test> getAll() {
        return testRepository.findAll();
    }



    @Override
    public void update(Test obj) {

    }

    @Override
    public void delete(Test obj) {
        testRepository.delete(obj);
    }

    @Override
    public Set<Question> findQuestionsByTId(int id) {
        return testRepository.findQuestionsByTId(id);
    }
}
