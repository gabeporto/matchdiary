package gabeporto.matchdiary.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import gabeporto.matchdiary.dto.match.MatchRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Table(name = "match")
@Entity(name = "match")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "date")
    private Date date;
    @Column(name = "score_team_one")
    private Integer scoreTeamOne;
    @Column(name = "score_team_two")
    private Integer scoreTeamTwo;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "team_one_id")
    private Team teamOne;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "team_two_id")
    private Team teamTwo;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "team_supported_id")
    private Team supportedTeam;

    public Match(MatchRequestDTO matchRequestDTO, Team teamOne, Team teamTwo, Team supportedTeam) {
        this.id = matchRequestDTO.getId();
        this.date = matchRequestDTO.getDate();
        this.scoreTeamOne = matchRequestDTO.getScoreTeamOne();
        this.scoreTeamTwo = matchRequestDTO.getScoreTeamTwo();
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.supportedTeam = supportedTeam;
    }
}
