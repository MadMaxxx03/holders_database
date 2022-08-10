package springApp.Controller;

import springApp.Classes.Holder;
import springApp.Service.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping("/holder")
public class HolderController {

    @Autowired
    private HolderService holderService;



    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public List<Holder> getAllReservations() {return holderService.getAll();}

    @RequestMapping
    public ResponseEntity<String> status() {
        return new ResponseEntity<>("Working...", HttpStatus.OK);
    }

}