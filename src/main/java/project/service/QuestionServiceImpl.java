package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.classes.Question;
import project.repository.QuestionRepository;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

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
        questionRepository.save(obj);
    }

    @Override
    public void delete(Question obj) {
        questionRepository.delete(obj);
    }

    @Override
    public boolean isObjPresent(Question obj) {
        return questionRepository.findById(obj.getqId()).isPresent();
    }
}
