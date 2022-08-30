package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.classes.Holder;
import project.classes.Test;
import project.classes.TestShort;
import project.repository.TestRepository;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public void save(Test obj) {
        testRepository.save(obj);
    }

    @Override
    public List<Test> getAll() {return testRepository.findAll();}

    @Override
    public void update(Test obj) {testRepository.save(obj);}

    @Override
    public void delete(Test obj) {
        testRepository.delete(obj);
    }

    @Override
    public Test getById(int id) {
        if (testRepository.findById(id).isPresent()){
            return testRepository.findById(id).get();
        }
        else{
            return null;
        }
    }

    @Override
    public boolean isObjPresent(Test obj) {
        return testRepository.findById(obj.gettId()).isPresent();
    }

    @Override
    public boolean isObjSame(Test obj) {
        if (testRepository.findById(obj.gettId()).isPresent()){
            Test test = testRepository.findById(obj.gettId()).get();
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public List<TestShort> getPart() {
        return testRepository.getPart();
    }
}
