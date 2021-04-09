package tads.eaj.ufrn.segundaprova.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.database.AppDatabase
import tads.eaj.ufrn.segundaprova.entities.Task

class CadastraFragmentViewModel(application: Application) : AndroidViewModel(application) {

    var taskTitle = MutableLiveData<String>("")
    var taskDescription = MutableLiveData<String>("")
    var taskStatus = MutableLiveData<String>("")
    var taskStart = MutableLiveData<String>("")
    var taskEnd = MutableLiveData<String>("")


    init {
        val db: AppDatabase by lazy {
            Room.databaseBuilder(application.applicationContext,
                AppDatabase::class.java, "task.sqlite")
                .allowMainThreadQueries()
                .build()
        }
    }

//    var task = Task(taskTitle.value!!, taskDescription.value!!, taskStatus.value!!, taskStart.value!!, taskEnd.value!!)
}