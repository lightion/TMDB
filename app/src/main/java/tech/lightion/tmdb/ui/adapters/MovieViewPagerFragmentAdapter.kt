package tech.lightion.tmdb.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import tech.lightion.tmdb.ui.fragments.CastDetailFragment
import tech.lightion.tmdb.ui.fragments.DescriptionDetailFragment

class MovieViewPagerFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> DescriptionDetailFragment()
            1 -> CastDetailFragment()
            else -> DescriptionDetailFragment()
        }
    }
}