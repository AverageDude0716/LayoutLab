package com.example.layoutlab


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

// ViewPagerAdapter extends FragmentStateAdapter to manage fragments in the ViewPager2
class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    // This method will return the appropriate fragment for each position (tab)
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Kitchen()  // Return the fragment for the first tab
            1 -> LivingRoom()  // Return the fragment for the second tab
            2 -> Bathroom()
            else -> Kitchen()  // Default case to return first tab fragment
        }
    }

    // Returns the total number of tabs (fragments)
    override fun getItemCount(): Int {
        return 3 // Update this if you have more tabs
    }
}
