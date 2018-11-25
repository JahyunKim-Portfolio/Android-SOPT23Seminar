package com.sopt23.seminar03.Adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.sopt23.seminar03.fragment.MainFragment
import com.sopt23.seminar03.fragment.MapFragment
import com.sopt23.seminar03.fragment.MyPageFragment

class MyFragmentStatePagerAdapter(fm : FragmentManager, val fCount : Int): FragmentStatePagerAdapter(fm){
    override fun getItem(position: Int): Fragment? {
        when(position){
            0 -> return MainFragment()
            1 -> {
                val mapFragment:Fragment = MapFragment()
                return mapFragment
            }
            2 -> return MyPageFragment()
            else -> return null
        }
    }

    override fun getCount(): Int = fCount;
}