package tads.eaj.ufrn.segundaprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.adapters.TaskAdapter
import tads.eaj.ufrn.segundaprova.databinding.FragmentHomeBinding
import tads.eaj.ufrn.segundaprova.entities.Task
import tads.eaj.ufrn.segundaprova.viewmodel.HomeFragmentViewModel

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewmodel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View{

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewmodel = ViewModelProvider(this).get(HomeFragmentViewModel::class.java)

        val adapter = TaskAdapter()
        val layout = LinearLayoutManager(parentFragment?.requireContext(), LinearLayoutManager.VERTICAL, false)

        binding.apply {
            recycleview.adapter = adapter
            recycleview.layoutManager = layout

            cadastraButton.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_homeFragment_to_cadastraFragment)
            }
        }

        setHasOptionsMenu(true)

        viewmodel.tasks.observe(viewLifecycleOwner, {
            adapter.tasks = it
            adapter.notifyDataSetChanged()
        })

        return binding.root
    }
}