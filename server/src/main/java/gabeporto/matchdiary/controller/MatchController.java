package gabeporto.matchdiary.controller;

import gabeporto.matchdiary.dto.match.MatchRequestDTO;
import gabeporto.matchdiary.dto.match.MatchResponseDTO;
import gabeporto.matchdiary.dto.team.TeamResponseDTO;
import gabeporto.matchdiary.model.Match;
import gabeporto.matchdiary.model.Team;
import gabeporto.matchdiary.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @GetMapping("{id}")
    public ResponseEntity<MatchResponseDTO> getMatchById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @PostMapping
    public ResponseEntity<Match> addMatch(@RequestBody MatchRequestDTO matchRequestDTO) {
        return ResponseEntity.ok(matchService.registerMatch(matchRequestDTO));
    }

    @PutMapping
    public ResponseEntity<Match> updateMatch(@RequestBody MatchRequestDTO matchRequestDTO) {
        return ResponseEntity.ok(matchService.updateMatch(matchRequestDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.ok("Partida deletada com sucesso.");
    }
}
