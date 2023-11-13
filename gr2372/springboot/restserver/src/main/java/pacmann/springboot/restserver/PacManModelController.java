package pacmann.springboot.restserver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import core.PacManUser;

@RestController
@RequestMapping("/api/highscores")
public class PacManModelController {

    public PacManModelController() {
    }
   
    @Autowired
    private PacManModelService service;

    @GetMapping
    public List<PacManUser> getAllHighScores(){
        return service.getHighScores();
    }

    @GetMapping("/test")
    public List<PacManUser> getAllTestHighScores(){
        service.setPersistanceLocation("/core/src/test/java/core/JSON/testScores.json");
        return service.getHighScores();
    }

    @PutMapping
    public void addHighScore(@RequestBody String user){
        service.addHighScore(user);
    }

    @PutMapping("/test")
    public void addTestHighScore(@RequestBody String user){
        service.setPersistanceLocation("/core/src/test/java/core/JSON/testScores.json");
        service.addHighScore(user);
    }
}
