package ganhar.emsfv.hockeyanalytics.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.REPOSITORY
import ganhar.emsfv.hockeyanalytics.db.NoteDatabase
import ganhar.emsfv.hockeyanalytics.db.repository.NoteRealization
import ganhar.emsfv.hockeyanalytics.model.LeagueMatchesModel
import ganhar.emsfv.hockeyanalytics.model.MatchModel
import ganhar.emsfv.hockeyanalytics.model.NewsModel
import ganhar.emsfv.hockeyanalytics.model.NoteModel

class MatchViewModel(private val context: Context) : ViewModel() {
    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITORY = NoteRealization(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITORY.allNotes
    }

    val listMatches = listOf(
        MatchModel(
            "ЦСКА",
            "Ак Барс",
            context.getString(R.string.cska),
            context.getString(R.string.ak_bars),
            "01.09.2023",
            0,
            0,
            listOf(
                "", ""
            ),
            listOf(
                "", ""
            )
        ),
        MatchModel(
            "Авангард",
            "Сибирь",
            context.getString(R.string.avangard),
            context.getString(R.string.sibir),
            "02.09.2023",
            0,
            0,
            listOf(
                "", ""
            ),
            listOf(
                "", ""
            )
        ),
        MatchModel(
            "Барыс",
            "Салават Юлаев",
            context.getString(R.string.barys),
            context.getString(R.string.salavat),
            "02.09.2023",
            0,
            0,
            listOf(
                "", ""
            ),
            listOf(
                "", ""
            )
        ),
        MatchModel(
            "Спартак",
            "Куньлунь Ред Стар",
            context.getString(R.string.spartak),
            context.getString(R.string.kunlun),
            "02.09.2023",
            0,
            0,
            listOf(
                "", ""
            ),
            listOf(
                "", ""
            )
        ),
        MatchModel(
            "Автомобилист",
            "Металлург Мг",
            context.getString(R.string.avtomobilist),
            context.getString(R.string.metallurg),
            "02.09.2023",
            15,
            0,
            listOf(
                "", ""
            ),
            listOf(
                "", ""
            )
        ),
    )

    private val nhlMatches = listOf(
        MatchModel(
            "Тампа-Бэй Лайтнинг",
            "Нэшвилл Предаторз",
            context.getString(R.string.tampa_bay_lightning),
            context.getString(R.string.nashville_predators),
            "11.10.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Питтсбург Пингвинз",
            "Чикаго Блэкхоукс",
            context.getString(R.string.pittsburgh_penguins),
            context.getString(R.string.chicago_blackhawks),
            "11.10.2023",
            3,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Вегас Голден Найтс",
            "Сиэтл Кракен",
            context.getString(R.string.vegas_golden_knights),
            context.getString(R.string.seattle_kraken),
            "11.10.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Торонто Мэйпл Лифс",
            "Монреаль Канадиенс",
            context.getString(R.string.toronto_maple_leafs),
            context.getString(R.string.montreal_canadiens),
            "12.10.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Каролина Харрикейнз",
            "Оттава Сенаторз",
            context.getString(R.string.carolina_hurricanes),
            context.getString(R.string.ottawa_senators),
            "12.10.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Бостон Брюинз",
            "Чикаго Блэкхоукс",
            context.getString(R.string.boston_bruins),
            context.getString(R.string.chicago_blackhawks),
            "12.10.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Ванкувер Кэнакс",
            "Эдмонтон Ойлерз",
            context.getString(R.string.vancouver_canucks),
            context.getString(R.string.edmonton_oilers),
            "12.10.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Лос-Анджелес Кингз",
            "Колорадо Эвеланш",
            context.getString(R.string.los_angeles_kings),
            context.getString(R.string.colorado_avalanche),
            "12.10.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Калгари Флэймз",
            "Виннипег Джетс",
            context.getString(R.string.calgary_flames),
            context.getString(R.string.winnipeg_jets),
            "12.10.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Баффало Сэйбрз",
            "Нью-Йорк Рейнджерс",
            context.getString(R.string.buffalo_sabres),
            context.getString(R.string.new_york_rangers),
            "13.10.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        )
    )
    private val khlMatches = listOf(
        MatchModel(
            "ЦСКА",
            "Ак Барс",
            context.getString(R.string.cska),
            context.getString(R.string.ak_bars),
            "01.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Авангард",
            "Сибирь",
            context.getString(R.string.avangard),
            context.getString(R.string.sibir),
            "02.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Барыс",
            "Салават Юлаев",
            context.getString(R.string.barys),
            context.getString(R.string.salavat),
            "02.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Спартак",
            "Куньлунь Ред Стар",
            context.getString(R.string.spartak),
            context.getString(R.string.kunlun),
            "02.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Автомобилист",
            "Металлург Мг",
            context.getString(R.string.avtomobilist),
            context.getString(R.string.metallurg),
            "02.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Лада",
            "Трактор",
            context.getString(R.string.lada),
            context.getString(R.string.traktor),
            "02.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Нефтехимик",
            "Динамо Мн",
            context.getString(R.string.neftekhimik),
            context.getString(R.string.dynamo_minsk),
            "02.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Северсталь",
            "ХК Сочи",
            context.getString(R.string.severstal),
            context.getString(R.string.hc_sochi),
            "02.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Витязь",
            "Амур",
            context.getString(R.string.vityaz),
            context.getString(R.string.amur),
            "02.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Динамо М",
            "СКА",
            context.getString(R.string.dynamo_moscow),
            context.getString(R.string.ska),
            "02.09.2023",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        )
    )
    private val lnhMatches = listOf(
        MatchModel(
            "Pays D'aix Uc",
            "US Creteil Handball",
            context.getString(R.string.pays_daix_uc),
            context.getString(R.string.us_creteil_handball),
            "2023-09-09",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Chartres Metropole Handball",
            "Montpellier Handball",
            context.getString(R.string.chartres_metropole_handball),
            context.getString(R.string.montpellier_handball),
            "2023-09-09",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Dijon Bourgogne",
            "US Ivry Handball",
            context.getString(R.string.dijon_bourgogne),
            context.getString(R.string.us_ivry_handball),
            "2023-09-09",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "US Creteil Handball",
            "GK Toulouse",
            context.getString(R.string.us_creteil_handball),
            context.getString(R.string.gk_toulouse),
            "2023-09-16",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Dijon Bourgogne",
            "USAM Nimes",
            context.getString(R.string.dijon_bourgogne),
            context.getString(R.string.usam_nimes),
            "2023-09-16",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Dunkerque Grand Littoral Handball",
            "Pays D'aix Uc",
            context.getString(R.string.dunkerque_grand_littoral_handball),
            context.getString(R.string.pays_daix_uc),
            "2023-09-16",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "US Ivry Handball",
            "Paris Handball",
            context.getString(R.string.us_ivry_handball),
            context.getString(R.string.paris_handball),
            "2023-09-16",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Montpellier Handball",
            "Chambery Savoie Handball",
            context.getString(R.string.montpellier_handball),
            context.getString(R.string.chambery_savoie_handball),
            "2023-09-16",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        ),
        MatchModel(
            "Limoges Handball 87",
            "Chartres Metropole Handball",
            context.getString(R.string.limoges_handball),
            context.getString(R.string.chartres_metropole_handball),
            "2023-09-14",
            0,
            0,
            listOf("", ""),
            listOf("", "")
        )
    )

    private val ahlMatches = listOf(
        MatchModel(
            "Grand Rapids Griffins",
            "Colorado Eagles",
            context.getString(R.string.grand_rapids_griffins),
            context.getString(R.string.colorado_eagles),
            "14.10",
            0,
            0,
            emptyList(),
            emptyList()
        ),
        MatchModel(
            "Laval Rocket",
            "Abbotsford Canucks",
            context.getString(R.string.laval_rocket),
            context.getString(R.string.abbotsford_canucks),
            "14.10",
            0,
            0,
            emptyList(),
            emptyList()
        ),
        MatchModel(
            "Charlotte",
            "Wilkes-Barre",
            context.getString(R.string.charlotte),
            context.getString(R.string.wilkes_barre),
            "14.10",
            0,
            0,
            emptyList(),
            emptyList()
        ),
        MatchModel(
            "Utica Comets",
            "Syracuse",
            context.getString(R.string.utica_comets),
            context.getString(R.string.syracuse),
            "14.10",
            0,
            0,
            emptyList(),
            emptyList()
        ),
        MatchModel(
            "Providence",
            "Hartford Wolf Pack",
            context.getString(R.string.providence),
            context.getString(R.string.hartford_wolf_pack),
            "14.10",
            0,
            0,
            emptyList(),
            emptyList()
        ),
        MatchModel(
            "Rochester",
            "Bridgeport Islanders",
            context.getString(R.string.rochester),
            context.getString(R.string.bridgeport_islanders),
            "14.10",
            0,
            0,
            emptyList(),
            emptyList()
        ),
        MatchModel(
            "Iowa Wild",
            "Henderson Silver Knights",
            context.getString(R.string.iowa_wild),
            context.getString(R.string.henderson_silver_knights),
            "14.10",
            0,
            0,
            emptyList(),
            emptyList()
        ),
        MatchModel(
            "Manitoba Moose",
            "Calgary Wranglers",
            context.getString(R.string.manitoba_moose),
            context.getString(R.string.calgary_wranglers),
            "14.10",
            0,
            0,
            emptyList(),
            emptyList()
        ),
    )

    val leaguesList: List<LeagueMatchesModel> = listOf(
        LeagueMatchesModel(
            context.getString(R.string.nhl),
            context.getString(R.string.nhl_img),
            nhlMatches
        ),
        LeagueMatchesModel(
            "KHL",
            context.getString(R.string.khl_img),
            khlMatches
        ),
        LeagueMatchesModel(
            "LHL",
            context.getString(R.string.lhl_img),
            lnhMatches
        ),
        LeagueMatchesModel(
            "AHL",
            context.getString(R.string.ahl_img),
            ahlMatches
        ),
    )
    val newsList: List<NewsModel> = listOf(
        NewsModel(context.getString(R.string.description_1), context.getString(R.string.img1)),
        NewsModel(context.getString(R.string.description_2), context.getString(R.string.img2)),
        NewsModel(context.getString(R.string.description_3), context.getString(R.string.img3)),
        NewsModel(context.getString(R.string.description_4), context.getString(R.string.img4)),
        NewsModel(context.getString(R.string.description_5), context.getString(R.string.img5)),
        NewsModel(context.getString(R.string.description_6), context.getString(R.string.img6)),
        NewsModel(context.getString(R.string.description_7), context.getString(R.string.img7)),
    )
}
