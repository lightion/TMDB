package tech.lightion.tmdb.ui.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.custom_app_bar.*
import kotlinx.android.synthetic.main.custom_app_bar.view.*

import tech.lightion.tmdb.R
import tech.lightion.tmdb.databinding.FragmentMainBinding
import tech.lightion.tmdb.viewmodel.MainFragmentViewModel

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    private val viewModel: MainFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )
        //viewModel.hideBottomNav.set(false)

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).setSupportActionBar(binding.customAppBar.toolBar)
        setupBottomNavigation()
        initObserver()

    }

    private fun setupBottomNavigation() {
        val navHostFragment = childFragmentManager.findFragmentById(R.id.main_fragment_nav_host)  as NavHostFragment
        NavigationUI.setupWithNavController(binding.bottomNavigation, navHostFragment.navController)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when(item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(context, "clicked on settings", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_logout -> {
                val action = MainFragmentDirections.actionMainFragmentToLoginFragment()
                Navigation.findNavController(binding.root).navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initObserver() {
        viewModel.hideBottomNavigation.observe(requireActivity(), Observer {
            if (it) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        })
    }
}
