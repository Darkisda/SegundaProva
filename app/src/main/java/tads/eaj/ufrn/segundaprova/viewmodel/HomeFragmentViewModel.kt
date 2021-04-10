package tads.eaj.ufrn.segundaprova.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.database.AppDatabase
import tads.eaj.ufrn.segundaprova.entities.Task

class HomeFragmentViewModel(application: Application) : AndroidViewModel(application) {
    var tasks: LiveData<List<Task>>

    var appDatabase: AppDatabase

    init {
        val db: AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
            AppDatabase::class.java, "task.sqlite")
                .allowMainThreadQueries()
                .build()
        }
        appDatabase = db
        tasks = FindAllByStatus().execute().get()
    }

    @SuppressLint("StaticFieldLeak")
    private inner class FindAllByStatus(): AsyncTask<Unit, Unit, LiveData<List<Task>>>() {
        override fun doInBackground(vararg params: Unit?): LiveData<List<Task>> {
            return appDatabase.taskDAO().findAllByStatus()
        }
    }
}