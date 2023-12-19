package gabeporto.matchdiary.service;

import gabeporto.matchdiary.dto.team.TeamRequestDTO;
import gabeporto.matchdiary.dto.team.TeamResponseDTO;
import gabeporto.matchdiary.model.Team;
import gabeporto.matchdiary.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public TeamResponseDTO getTeamById(final Long id) {

        if(id <= 0) {
            return new TeamResponseDTO();
        }

        Optional<Team> response = teamRepository.findById(id);

        return response.map(TeamResponseDTO::new).orElseGet(TeamResponseDTO::new);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAllOrderedById();
    }

    public Team registerTeam(final TeamRequestDTO teamRequestDTO) {

        if(teamRequestDTO.getName().isEmpty()
                || teamRequestDTO.getState().isEmpty()
                || teamRequestDTO.getPhotoUrl().isEmpty()) {
            return null;
        }

        Team team = new Team(teamRequestDTO);
        return teamRepository.save(team);
    }

    public Team updateTeam(final TeamRequestDTO teamRequestDTO) {

        if(teamRequestDTO.getName().isEmpty()
                || teamRequestDTO.getState().isEmpty()
                || teamRequestDTO.getPhotoUrl().isEmpty()) {
            return null;
        }

        Team team = new Team(teamRequestDTO);
        return teamRepository.save(team);
    }

    public void deleteTeam(final Long id) {
        teamRepository.deleteById(id);
    }
}
