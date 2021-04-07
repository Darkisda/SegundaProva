package tads.eaj.ufrn.segundaprova.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.segundaprova.R

class TaskViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val taskTitle: TextView
    val taskDescription: TextView
    val taskStatus: TextView
    val taskStart: TextView
    val taskEnd: TextView

    init {
        taskTitle = v.findViewById(R.id.taskTitle)
        taskDescription = v.findViewById(R.id.taskDescription)
        taskStatus = v.findViewById(R.id.taskStatus)
        taskStart = v.findViewById(R.id.taskStart)
        taskEnd = v.findViewById(R.id.taskEnd)
    }
}