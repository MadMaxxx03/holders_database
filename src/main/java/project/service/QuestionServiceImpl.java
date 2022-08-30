package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.classes.Question;
import project.classes.QuestionShort;
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
    public Question getById(int id) {
        if(questionRepository.findById(id).isPresent()){
            return questionRepository.findById(id).get();
        }
        else{
            return null;
        }
    }

    @Override
    public boolean isObjPresent(Question obj) {
        return questionRepository.findById(obj.getqId()).isPresent();
    }

    @Override
    public boolean isObjSame(Question obj) {
        return questionRepository.findById(obj.getqId()).equals(obj);
    }

    @Override
    public List<QuestionShort> getPart() {
        return  questionRepository.getPart();
    }
}
