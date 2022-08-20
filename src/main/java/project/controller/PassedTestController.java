package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import project.classes.Holder;
import project.classes.PassedTest;
import project.service.HolderService;
import project.service.PassedTestService;
import project.service.TestService;

import java.util.List;


@Controller
@RequestMapping("/passedtest")
public class PassedTestController {

    @Autowired
    private PassedTestService passedTestService;

    @Autowired
    private HolderService holderService;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<PassedTest>> getAll() {
        return new ResponseEntity<>(passedTestService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> save(@RequestBody PassedTest passedTest) {
        if(!passedTestService.isObjPresent(passedTest)
                && holderService.isObjPresent(passedTest.getHolder())
                && testService.isObjPresent(passedTest.getTest())){
            passedTestService.save(passedTest);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> delete(@RequestBody PassedTest passedTest) {
        passedTestService.delete(passedTest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> update(@RequestBody PassedTest passedTest) {
        if(passedTestService.isObjPresent(passedTest)
                && holderService.isObjPresent(passedTest.getHolder())
                && testService.isObjPresent(passedTest.getTest())){
            passedTestService.update(passedTest);
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
