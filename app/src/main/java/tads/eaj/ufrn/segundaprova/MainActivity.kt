package tads.eaj.ufrn.segundaprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.database.AppDatabase
import tads.eaj.ufrn.segundaprova.databinding.ActivityMainBinding
import tads.eaj.ufrn.segundaprova.entities.Task

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val db : AppDatabase by lazy {
        Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "task.sqlite")
                .allowMainThreadQueries()
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}