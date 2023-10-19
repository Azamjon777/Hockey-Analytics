package ganhar.emsfv.hockeyanalytics.model

import java.io.Serializable

class LeagueMatchesModel(
    val leagueName: String,
    val leagueImg: String,
    val listOfMatches: List<MatchModel>
) : Serializable