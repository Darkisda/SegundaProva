package tads.eaj.ufrn.segundaprova.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task(
    @ColumnInfo(name = "task_title") val title: String,
    @ColumnInfo(name = "task_description") val description: String,
    @ColumnInfo(name = "task_status") val status: String,
    @ColumnInfo(name = "task_start") val start: String,
    @ColumnInfo(name = "task_end") val end: String
) {
    @PrimaryKey (autoGenerate = true)
    var id: Int = 0
}
