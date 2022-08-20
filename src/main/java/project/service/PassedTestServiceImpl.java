package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.classes.PassedTest;
import project.repository.PassedTestRepository;

import java.util.List;

@Service
public class PassedTestServiceImpl implements PassedTestService {

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
        passedTestRepository.save(obj);
    }

    @Override
    public void delete(PassedTest obj) {
        passedTestRepository.delete(obj);
    }

    @Override
    public boolean isObjPresent(PassedTest obj) {
        return passedTestRepository.findById(obj.getpId()).isPresent();
    }
}
