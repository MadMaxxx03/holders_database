package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.classes.Holder;
import project.classes.Test;
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
    public boolean isObjPresent(Test obj) {
        return testRepository.findById(obj.gettId()).isPresent();
    }

}
