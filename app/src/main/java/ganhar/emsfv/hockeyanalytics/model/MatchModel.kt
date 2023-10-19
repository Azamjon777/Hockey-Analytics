package ganhar.emsfv.hockeyanalytics.model

import java.io.Serializable

class MatchModel(
    val team1Name: String,
    val team2Name: String,
    val team1Img: String,
    val team2Img: String,
    val totalScoreOrDate: String,
    val team1Score: Int,
    val team2Score: Int,
    val team1ListOfScorers: List<String>,
    val team2ListOfScorers: List<String>
) : Serializable