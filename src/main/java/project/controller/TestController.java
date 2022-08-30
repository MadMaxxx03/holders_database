package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.classes.Test;
import project.classes.TestShort;
import project.service.HolderService;
import project.service.TestService;

import java.util.List;


@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private HolderService holderService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<TestShort>> getAll() {
        return new ResponseEntity<>(testService.getPart(), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> save(@RequestBody Test test) {
        if(!testService.isObjPresent(test) && holderService.isObjPresent(test.getHolder())){
            test.setHolder(holderService.getById(test.getHolder().gethId()));
            testService.save(test);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> delete(@RequestBody Test test) {
        testService.delete(test);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> update(@RequestBody Test test) {
        if(testService.isObjPresent(test) && holderService.isObjPresent(test.getHolder())){
            test.setHolder(holderService.getById(test.getHolder().gethId()));
            testService.update(test);
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
