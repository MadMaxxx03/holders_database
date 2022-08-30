package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.classes.Question;
import project.classes.QuestionShort;
import project.service.QuestionService;
import project.service.TestService;

import java.util.List;


@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<QuestionShort>> getAll() {
        return new ResponseEntity<>(questionService.getPart(), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> save(@RequestBody Question question) {
        if(!questionService.isObjPresent(question) && testService.isObjPresent(question.getTest())){
            question.setTest(testService.getById(question.getTest().gettId()));
            questionService.save(question);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> delete(@RequestBody Question question) {
        questionService.delete(question);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> update(@RequestBody Question question) {
        if(questionService.isObjPresent(question) && testService.isObjPresent(question.getTest())){
            question.setTest(testService.getById(question.getTest().gettId()));
            questionService.update(question);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Working...", HttpStatus.OK);
    }

}
