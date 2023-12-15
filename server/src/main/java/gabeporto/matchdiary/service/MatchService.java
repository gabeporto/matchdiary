package gabeporto.matchdiary.service;

import gabeporto.matchdiary.dto.match.MatchRequestDTO;
import gabeporto.matchdiary.dto.match.MatchResponseDTO;
import gabeporto.matchdiary.model.Match;
import gabeporto.matchdiary.model.Team;
import gabeporto.matchdiary.repository.MatchRepository;
import gabeporto.matchdiary.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private TeamRepository teamRepository;

    public MatchResponseDTO getMatchById(final Long id) {

        if(id <= 0) {
            return new MatchResponseDTO();
        }

        Optional<Match> response = matchRepository.findById(id);

        return response.map(MatchResponseDTO::new).orElseGet(MatchResponseDTO::new);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Match registerMatch(final MatchRequestDTO matchRequestDTO) {

        if(matchRequestDTO.getScoreTeamOne().toString().isEmpty() ||
                matchRequestDTO.getScoreTeamTwo().toString().isEmpty() ||
                matchRequestDTO.getSupportedTeamId().toString().isEmpty() ||
                matchRequestDTO.getTeamOneId().toString().isEmpty() ||
                matchRequestDTO.getTeamTwoId().toString().isEmpty()
        ) {
            return null;
        }

        Team teamOne = teamRepository.findById(matchRequestDTO.getTeamOneId()).orElseThrow(() -> new IllegalArgumentException("Time 1 não encontrado"));
        Team teamTwo = teamRepository.findById(matchRequestDTO.getTeamTwoId()).orElseThrow(() -> new IllegalArgumentException("Time 2 não encontrado"));
        Team supportedTeam = teamRepository.findById(matchRequestDTO.getSupportedTeamId()).orElseThrow(() -> new IllegalArgumentException("Time de torcida não encontrado"));

        Match match = new Match(matchRequestDTO, teamOne, teamTwo, supportedTeam);
        return matchRepository.save(match);
    }

    public Match updateMatch(final MatchRequestDTO matchRequestDTO) {

        if(matchRequestDTO.getScoreTeamOne().toString().isEmpty() ||
                matchRequestDTO.getScoreTeamTwo().toString().isEmpty() ||
                matchRequestDTO.getSupportedTeamId().toString().isEmpty() ||
                matchRequestDTO.getTeamOneId().toString().isEmpty() ||
                matchRequestDTO.getTeamTwoId().toString().isEmpty()
        ) {
            return null;
        }

        Team teamOne = teamRepository.findById(matchRequestDTO.getTeamOneId()).orElseThrow(() -> new IllegalArgumentException("Time 1 não encontrado"));
        Team teamTwo = teamRepository.findById(matchRequestDTO.getTeamTwoId()).orElseThrow(() -> new IllegalArgumentException("Time 2 não encontrado"));
        Team supportedTeam = teamRepository.findById(matchRequestDTO.getSupportedTeamId()).orElseThrow(() -> new IllegalArgumentException("Time de torcida não encontrado"));

        Match match = new Match(matchRequestDTO, teamOne, teamTwo, supportedTeam);
        return matchRepository.save(match);
    }

    public void deleteMatch(final Long id) {
        matchRepository.deleteById(id);
    }
}
