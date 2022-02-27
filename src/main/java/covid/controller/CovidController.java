package covid.controller;

import covid.entity.CovidInfo;
import covid.entity.User;
import covid.repository.UserRepository;
import covid.service.CovidInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CovidController {
    private final CovidInfoService covidInfoService;
    private final UserRepository userRepository;

    @Autowired
    public CovidController(CovidInfoService covidInfoService, UserRepository userRepository) {
        this.covidInfoService = covidInfoService;
        this.userRepository = userRepository;
    }

    @GetMapping("/covid")
    public ResponseEntity<CovidInfo> getCovid(Principal principal) {
        return new ResponseEntity<>(covidInfoService.getCovidInfo(principal), HttpStatus.OK);
    }

    @PostMapping("/covid")
    public ResponseEntity<CovidInfo> addCovid(@RequestBody CovidInfo covidInfo, Principal principal) {
        System.out.println(covidInfo);
        return new ResponseEntity<>(covidInfoService.createCovidInfo(covidInfo, principal), HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> users() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }
}
