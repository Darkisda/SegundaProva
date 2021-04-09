package tads.eaj.ufrn.segundaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.database.AppDatabase
import tads.eaj.ufrn.segundaprova.entities.Task

class MainActivity : AppCompatActivity() {

    private val db : AppDatabase by lazy {
        Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "task.sqlite")
                .allowMainThreadQueries()
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}