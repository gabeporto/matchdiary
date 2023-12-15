package gabeporto.matchdiary.controller;

import gabeporto.matchdiary.model.Team;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @GetMapping("/all")
    public String getAllMatches() {
        return "";
    }

    @GetMapping("{id}")
    public String getMatchById(@PathVariable("id") Long id) {
        return "";
    }

    @PostMapping
    public String addMatch(@RequestBody Team team) {
        return "";
    }

    @PutMapping
    public String updateMatch(@RequestBody Team team) {
        return "";
    }

    @DeleteMapping("{id}")
    public String deleteMatch(@PathVariable("id") Long id) {
        return "";
    }
}
