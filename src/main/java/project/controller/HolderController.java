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
import project.classes.HolderShort;
import project.service.HolderService;

import java.util.List;


@Controller
@RequestMapping("/holder")
public class HolderController {

    @Autowired
    private HolderService holderService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<HolderShort>> getAll() {
        return new ResponseEntity<>(holderService.getPart(), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> save(@RequestBody Holder holder) {
        if(!holderService.isObjPresent(holder)){
            holderService.save(holder);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> delete(@RequestBody Holder holder) {
        holderService.delete(holder);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> update(@RequestBody Holder holder) {
        if(holderService.isObjPresent(holder)){
            holderService.update(holder);
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