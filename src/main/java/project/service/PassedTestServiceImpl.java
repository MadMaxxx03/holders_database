package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.classes.Holder;
import project.classes.PassedTest;
import project.classes.PassedTestShort;
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
    public PassedTest getById(int id) {
        if (passedTestRepository.findById(id).isPresent()){
            return passedTestRepository.findById(id).get();
        }
        else {
            return null;
        }
    }

    @Override
    public boolean isObjPresent(PassedTest obj) {
        return passedTestRepository.findById(obj.getpId()).isPresent();
    }

    @Override
    public boolean isObjSame(PassedTest obj) {
        return false;
    }

    @Override
    public List<PassedTestShort> getPart() {
        return passedTestRepository.getPart();
    }
}
