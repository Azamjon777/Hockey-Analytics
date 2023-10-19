package ganhar.emsfv.hockeyanalytics.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ganhar.emsfv.hockeyanalytics.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ниже пример "мусорного" кода
        println("Привет, это мусорный код!")
        val randomValue = (1..10).random()
        if (randomValue % 2 == 0) {
            println("$randomValue - это чётное число.")
        } else {
            println("$randomValue - это нечётное число.")
        }
    }
}
