package tads.eaj.ufrn.segundaprova.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.database.AppDatabase
import tads.eaj.ufrn.segundaprova.entities.Task

class DetalhesFragmentViewModel(application: Application): AndroidViewModel(application) {
    var appDatabase: AppDatabase

    var taskTitle = ""
    var taskDescription = ""
    var taskStatus = ""
    var taskStart = ""
    var taskEnd = ""

    init {
        val db : AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "task.sqlite")
                .allowMainThreadQueries()
                .build()
        }

        appDatabase = db
    }

    fun findTaskById(id: Int) {
        var task = FindTaskByID(id).execute().get()

        this.taskTitle = task.title
        this.taskDescription = task.description
        this.taskStatus = task.status
        this.taskStart = task.start
        this.taskEnd = task.end
    }


    @SuppressLint("StaticFieldLeak")
    private inner class FindTaskByID(var id: Int): AsyncTask<Unit, Unit, Task>() {
        override fun doInBackground(vararg params: Unit?): Task {
            return appDatabase.taskDAO().findByID(id)
        }
    }
}