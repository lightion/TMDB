package tech.lightion.tmdb.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import tech.lightion.tmdb.R
import tech.lightion.tmdb.databinding.FragmentStreamingBinding
import tech.lightion.tmdb.extensions.waitForTransition
import tech.lightion.tmdb.ui.adapters.MovieListAdapter
import tech.lightion.tmdb.viewmodel.MainFragmentViewModel
import tech.lightion.tmdb.viewmodel.StreamingViewModel

/**
 * A simple [Fragment] subclass.
 */
class StreamingFragment : Fragment() {

    lateinit var viewModel: StreamingViewModel
    lateinit var binding: FragmentStreamingBinding
    private val sharedViewModel: MainFragmentViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_streaming,
            container,
            false
            )
        viewModel = ViewModelProvider(this).get(StreamingViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.setListData()
        sharedViewModel.loading.value = false
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObserver()
        waitForTransition(binding.streamingRecyclerView)
    }

    override fun onResume() {
        super.onResume()
        val isSetHidden = sharedViewModel.hideBottomNavigation.value ?: false
        if(isSetHidden)
            sharedViewModel.setBottomNavVisibilityHidden(false)
    }

    private fun initObserver() {
        viewModel.itemList.observe(requireActivity(), Observer {
            val adapter = MovieListAdapter(it)
            binding.adapter = adapter
        })
    }
}
