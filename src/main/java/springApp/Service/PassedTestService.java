package springApp.Service;

import springApp.Classes.PassedTest;
import springApp.DAO.PassedTestDAO;
import springApp.Repository.PassedTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PassedTestService implements PassedTestDAO {

    @Autowired
    private PassedTestRepository passedTestRepository;

    @Override
    public void save(PassedTest obj) {
        passedTestRepository.save(obj);
    }

    @Override
    public List<PassedTest> getAll() {
        return passedTestRepository.findAll();
    }


    @Override
    public void update(PassedTest obj) {

    }

    @Override
    public void delete(PassedTest obj) {
        passedTestRepository.delete(obj);
    }
}
