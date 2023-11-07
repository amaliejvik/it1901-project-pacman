package pacmann.springboot.restserver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import core.PacManUser;

@RestController
@RequestMapping("/api/highscores")
public class PacManModelController {
   
    @Autowired
    private PacManModelService service;

    @GetMapping
    public List<PacManUser> getAllHighScores(){
        return service.getHighScores();
    }

    @PutMapping
    public void addHighScore(@RequestBody String user){
        service.addHighScore(user);
    }
}
