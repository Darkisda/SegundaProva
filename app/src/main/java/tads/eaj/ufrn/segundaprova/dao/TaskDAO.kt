package tads.eaj.ufrn.segundaprova.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import tads.eaj.ufrn.segundaprova.entities.Task

@Dao
interface TaskDAO {
    @Query("SELECT * FROM task_table")
    fun findAll(): LiveData<List<Task>>

    @Query("SELECT * FROM task_table WHERE task_status = 'ATIVO' ")
    fun findAllByStatus(): LiveData<List<Task>>

    @Query("SELECT * FROM task_table WHERE id = :id")
    fun findByID(id: Int): Task

    @Insert
    fun createTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)
}