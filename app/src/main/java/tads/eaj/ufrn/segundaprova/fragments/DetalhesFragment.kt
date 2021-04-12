package tads.eaj.ufrn.segundaprova.fragments

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.room.Room
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.database.AppDatabase
import tads.eaj.ufrn.segundaprova.databinding.FragmentDetalhesBinding
import tads.eaj.ufrn.segundaprova.entities.Task
import tads.eaj.ufrn.segundaprova.viewmodel.DetalhesFragmentViewModel

class DetalhesFragment : Fragment() {

    lateinit var binding: FragmentDetalhesBinding
    lateinit var viewmodel: DetalhesFragmentViewModel

    val args: DetalhesFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        viewmodel = ViewModelProvider(this).get(DetalhesFragmentViewModel::class.java)

        viewmodel.findTaskById(args.taskId)

        binding.apply {
            detailsTaskTitle.text = viewmodel.taskTitle
            detailsTaskDesc.text = viewmodel.taskDescription
            detailsTaskStatus.text = viewmodel.taskStatus
            detailsTaskStart.text = viewmodel.taskStart
            detailsTaskEnd.text = viewmodel.taskEnd
        }

        return binding.root
    }
}