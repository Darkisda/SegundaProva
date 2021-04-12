package tads.eaj.ufrn.segundaprova.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import tads.eaj.ufrn.segundaprova.R
import tads.eaj.ufrn.segundaprova.adapters.TaskAdapter
import tads.eaj.ufrn.segundaprova.databinding.FragmentHomeBinding
import tads.eaj.ufrn.segundaprova.utils.RecyclerViewClickListener
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

            recycleview.addOnItemTouchListener(
                    RecyclerViewClickListener(this@HomeFragment.requireContext(),
                    recycleview,
                    object: RecyclerViewClickListener.clickListener {
                        override fun onClick(v: View, position: Int) {
                            Navigation.findNavController(v).navigate(
                                HomeFragmentDirections.actionHomeFragmentToDetalhesFragment().setTaskId(viewmodel.tasks.value!![position].id)
                            )
                        }

                        override fun onHolding(v: View, position: Int) {
                            Navigation.findNavController(v).navigate(
                                HomeFragmentDirections.actionHomeFragmentToAlteraFragment().setTaskId(viewmodel.tasks.value!![position].id)
                            )
                        }
                    })
            )

        }

        viewmodel.tasks.observe(viewLifecycleOwner, {
            adapter.tasks = it
            adapter.notifyDataSetChanged()
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, this.findNavController()) || super.onOptionsItemSelected(item)
    }
}