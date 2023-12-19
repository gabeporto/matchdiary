package gabeporto.matchdiary.controller;

import gabeporto.matchdiary.dto.match.MatchRequestDTO;
import gabeporto.matchdiary.dto.match.MatchResponseDTO;
import gabeporto.matchdiary.model.Match;
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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/all")
    public List<Match> getAllMatches() {
        return matchService.getAllMatches();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("{id}")
    public ResponseEntity<MatchResponseDTO> getMatchById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(matchService.getMatchById(id));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity<Match> addMatch(@RequestBody MatchRequestDTO matchRequestDTO) {
        return ResponseEntity.ok(matchService.registerMatch(matchRequestDTO));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
    public ResponseEntity<Match> updateMatch(@RequestBody MatchRequestDTO matchRequestDTO) {
        return ResponseEntity.ok(matchService.updateMatch(matchRequestDTO));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteMatch(@PathVariable("id") Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.ok("Partida deletada com sucesso.");
    }
}
