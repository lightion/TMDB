package tech.lightion.tmdb.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import tech.lightion.tmdb.R
import tech.lightion.tmdb.databinding.FragmentCastDetailBinding
import tech.lightion.tmdb.model.Movie
import tech.lightion.tmdb.ui.adapters.CastListAdapter
import tech.lightion.tmdb.viewmodel.CastViewModel

/**
 * A simple [Fragment] subclass.
 */
class CastDetailFragment(val movie: Movie) : Fragment() {

    lateinit var viewModel: CastViewModel
    lateinit var binding: FragmentCastDetailBinding
    var castListAdapter = CastListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_cast_detail,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(CastViewModel::class.java)
        viewModel.setListData(movie.id)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.castRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = castListAdapter
        }
        initObserver()
    }

    private fun initObserver(){
        viewModel.itemList.observe(requireActivity(), Observer {casts ->
            casts?.let {
                binding.castRecyclerView.visibility = View.VISIBLE
                castListAdapter.updateCast(it)
            }
        })
        viewModel.loading.observe(requireActivity(), Observer {isLoading ->
            isLoading?.let {
                binding.progressBar.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    binding.castRecyclerView.visibility = View.GONE
                }
            }
        })
    }

}
