package gabeporto.matchdiary.controller;

import gabeporto.matchdiary.dto.team.TeamResponseDTO;
import gabeporto.matchdiary.model.Team;
import gabeporto.matchdiary.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @GetMapping("/all")
    public String getAllTeams() {
        return "";
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamResponseDTO> getTeamById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @PostMapping
    public String addTeam(@RequestBody Team team) {
        return "";
    }

    @PutMapping
    public String updateTeam(@RequestBody Team team) {
        return "";
    }

    @DeleteMapping("{id}")
    public String deleteTeam(@RequestParam("id") Long id) {
        return "";
    }

}
