package com.saturnus.mymanagementgudang.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.saturnus.mymanagementgudang.tabs.TabHome
import com.saturnus.mymanagementgudang.tabs.TabTransaksi

class TabPageAdapter (activity: FragmentActivity, private val tabCount: Int)
    : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = tabCount

    override fun createFragment(position: Int): Fragment {
        return when (position)
        {
            0 -> TabHome()
            1 -> TabTransaksi()
            else -> TabHome()
        }
    }
}