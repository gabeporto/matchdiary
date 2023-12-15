package gabeporto.matchdiary.dto.reports;

import gabeporto.matchdiary.model.Team;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportsResponseDTO {

    private Integer matchesQuantity;
    private Integer winsQuantity;
    private Integer winPercentage;
    private Team mostWatchedTeam;
    private Integer daysWithoutWatching;
}
