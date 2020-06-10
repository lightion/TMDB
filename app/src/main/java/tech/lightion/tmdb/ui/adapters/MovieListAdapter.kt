package tech.lightion.tmdb.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView
import tech.lightion.tmdb.databinding.MovieCardItemBinding
import tech.lightion.tmdb.extensions.loadImage
import tech.lightion.tmdb.extensions.toTransitionGroup
import tech.lightion.tmdb.model.Movie
import tech.lightion.tmdb.ui.fragments.StreamingFragmentDirections

/**
 * RecyclerView Adapter for the MovieList present in the StreamingFragment
 */
class MovieListAdapter (
    private val movieList: List<Movie>
) : RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = MovieCardItemBinding.inflate(layoutInflater)
        return MovieListViewHolder(binding)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val movie: Movie = movieList[position]
        holder.bind(movie)
    }

    inner class MovieListViewHolder(
        val binding: MovieCardItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie : Movie) {
            binding.movie = movie
            binding.movieCardImageView.loadImage(movie.imageUrl)
            binding.executePendingBindings()

            binding.root.setOnClickListener {
                val action = StreamingFragmentDirections.actionStreamingToMovieDetailFragment2(movie)
                val extras = FragmentNavigatorExtras(
                    binding.movieCardImageView.toTransitionGroup(),
                    binding.movieCardTitleTextView.toTransitionGroup()
                )
                Navigation.findNavController(it).navigate(action, extras)
            }
        }
    }
}
