package tads.eaj.ufrn.segundaprova.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.databinding.FragmentAlteraBinding
import tads.eaj.ufrn.segundaprova.viewmodel.AlteraFragmentViewModel
import kotlin.math.log

class AlteraFragment : Fragment() {


    lateinit var binding: FragmentAlteraBinding
    lateinit var viewModel: AlteraFragmentViewModel

    val args: AlteraFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewModel = ViewModelProvider(this).get(AlteraFragmentViewModel::class.java)

        viewModel.findTaskById(args.taskId)

        Log.i("DEBUG", args.taskId.toString())

        binding.apply {
            editTaskTitle.setText(viewModel.taskTitle)
            editTaskDesc.setText(viewModel.taskDescription)
            editTaskStatus.setText(viewModel.taskStatus)
            editTaskStart.setText(viewModel.taskStart)
            editTaskEnd.setText(viewModel.taskEnd)


            editarButton.setOnClickListener {

                viewModel.taskTitle = editTaskTitle.text.toString()
                viewModel.taskDescription = editTaskDesc.text.toString()
                viewModel.taskStatus = editTaskStatus.text.toString()
                viewModel.taskStart = editTaskStart.text.toString()
                viewModel.taskEnd = editTaskEnd.text.toString()

                viewModel.editTask(args.taskId)

                Toast.makeText(context, "Alterações feitas com sucesso!", Toast.LENGTH_SHORT).show()

                Navigation.findNavController(it).navigate(
                    AlteraFragmentDirections.actionAlteraFragmentToHomeFragment()
                )
            }
        }

        return binding.root
    }
}