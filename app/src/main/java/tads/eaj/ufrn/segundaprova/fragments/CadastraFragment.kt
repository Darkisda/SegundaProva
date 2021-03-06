package tads.eaj.ufrn.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.databinding.FragmentCadastraBinding
import tads.eaj.ufrn.segundaprova.viewmodel.CadastraFragmentViewModel

class CadastraFragment : Fragment() {

    lateinit var binding: FragmentCadastraBinding
    lateinit var viewmodel: CadastraFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastra, container, false)
        viewmodel = ViewModelProvider(this).get(CadastraFragmentViewModel::class.java)

        binding.viewmodel = viewmodel
        binding.lifecycleOwner = this

        binding.apply {

            inputTaskTitle.addTextChangedListener {
                viewmodel?.taskTitle = it.toString()
            }

            inputTaskDescription.addTextChangedListener {
                viewmodel?.taskDescription = it.toString()
            }

            inputTaskStatus.addTextChangedListener {
                viewmodel?.taskStatus = it.toString()
            }

            inputTaskStart.addTextChangedListener {
                viewmodel?.taskStart = it.toString()
            }

            inputTaskEnd.addTextChangedListener {
                viewmodel?.taskEnd = it.toString()
            }

            cadastraButton.setOnClickListener {
                if( viewmodel?.taskTitle != "" && viewmodel?.taskDescription != "" && viewmodel?.taskStatus != "" && viewmodel?.taskStart != "" && viewmodel?.taskEnd != "") {
                    viewmodel?.createTask()
                    Navigation.findNavController(it).navigate(R.id.action_cadastraFragment_to_homeFragment)
                }
                else {
                    Toast.makeText(parentFragment?.requireContext(), "Por favor preencha todos os campos", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }
}