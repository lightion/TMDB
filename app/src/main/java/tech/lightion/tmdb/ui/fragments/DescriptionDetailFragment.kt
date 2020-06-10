package tech.lightion.tmdb.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil

import tech.lightion.tmdb.R
import tech.lightion.tmdb.databinding.FragmentDescriptionDetailBinding
import tech.lightion.tmdb.model.Movie

/**
 *  A [Fragment] subclass used to display the description of the movie.
 */
class DescriptionDetailFragment(val movie: Movie) : Fragment() {

    lateinit var binding: FragmentDescriptionDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_description_detail,
            container,
            false
        )
        binding.movie = movie
        return binding.root
    }

}
