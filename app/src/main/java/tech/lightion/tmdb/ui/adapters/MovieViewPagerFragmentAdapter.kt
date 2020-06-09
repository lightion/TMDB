package tech.lightion.tmdb.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import tech.lightion.tmdb.model.Movie
import tech.lightion.tmdb.ui.fragments.CastDetailFragment
import tech.lightion.tmdb.ui.fragments.DescriptionDetailFragment
/**
 * Used for sliding tab present the MovieDetailFragment
 */
class MovieViewPagerFragmentAdapter(fragment: Fragment, val movie: Movie) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> DescriptionDetailFragment(movie)
            1 -> CastDetailFragment(movie)
            else -> DescriptionDetailFragment(movie)
        }
    }
}