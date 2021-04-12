package tads.eaj.ufrn.segundaprova.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.entities.Task

class TaskAdapter() : RecyclerView.Adapter<TaskViewHolder>() {
    var tasks: List<Task> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_inflater, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val chosenTask = tasks[position]

        holder.taskTitle.text = chosenTask.title
        holder.taskStatus.text = chosenTask.status
        holder.taskStart.text = chosenTask.start
        holder.taskEnd.text = chosenTask.end
    }
}