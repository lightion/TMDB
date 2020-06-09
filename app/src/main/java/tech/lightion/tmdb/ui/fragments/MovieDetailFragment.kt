package tech.lightion.tmdb.ui.fragments

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator

import tech.lightion.tmdb.R
import tech.lightion.tmdb.databinding.FragmentMovieDetailBinding
import tech.lightion.tmdb.extensions.loadImage
import tech.lightion.tmdb.ui.adapters.MovieViewPagerFragmentAdapter
import tech.lightion.tmdb.viewmodel.MainFragmentViewModel

/**
 * A [Fragment] subclass for the movie details.
 */
class MovieDetailFragment : Fragment() {

    private val viewModel: MainFragmentViewModel by activityViewModels()
    private val args: MovieDetailFragmentArgs by navArgs()

    private lateinit var binding: FragmentMovieDetailBinding
    private lateinit var adapter: MovieViewPagerFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movie_detail,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setBottomNavVisibilityHidden(true)
        binding.movie = args.movie
        binding.movieCardImageView.loadImage(args.movie.imageUrl)
        binding.executePendingBindings()
        adapter =
            MovieViewPagerFragmentAdapter(this, args.movie)
        binding.detailMovieViewPager.adapter = adapter

        TabLayoutMediator(binding.detailTabLayout, binding.detailMovieViewPager) { tab, position ->
            tab.text = when(position) {
                0 -> "Description"
                1 -> "Cast"
                else -> ""
            }
        }.attach()
    }



}
