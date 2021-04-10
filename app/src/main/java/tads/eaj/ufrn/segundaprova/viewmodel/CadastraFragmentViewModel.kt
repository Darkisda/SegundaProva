package tads.eaj.ufrn.segundaprova.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.database.AppDatabase
import tads.eaj.ufrn.segundaprova.entities.Task

class CadastraFragmentViewModel(application: Application) : AndroidViewModel(application) {

    private var appDatabase: AppDatabase

    var taskTitle = ""
    var taskDescription = ""
    var taskStatus = ""
    var taskStart = ""
    var taskEnd = ""


    init {
        val db: AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "task.sqlite")
                .allowMainThreadQueries()
                .build()
        }

        appDatabase = db
    }

    @SuppressLint("StaticFieldLeak")
    private inner class CreateTask() : AsyncTask<String, String, Unit>() {
        override fun doInBackground(vararg params: String?) {
            val task = Task(taskTitle, taskDescription, taskStatus, taskStart, taskEnd)

            appDatabase.taskDAO().createTask(task)
        }
    }

    fun createTask() {
        CreateTask().execute().get()
    }
}