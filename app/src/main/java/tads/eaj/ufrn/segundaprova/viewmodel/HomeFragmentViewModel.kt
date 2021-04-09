package tads.eaj.ufrn.segundaprova.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.database.AppDatabase
import tads.eaj.ufrn.segundaprova.entities.Task

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var tasks: LiveData<List<Task>>

    init {
        val db: AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
            AppDatabase::class.java, "task.sqlite")
                .allowMainThreadQueries()
                .build()
        }
        tasks = db.taskDAO().findAllByStatus()
    }
}