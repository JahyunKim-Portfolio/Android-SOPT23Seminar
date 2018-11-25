package com.sopt23.seminar02.fragment

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt23.seminar02.R

class HomeFragment : android.support.v4.app.Fragment(){
    companion object{
        var mInstance : HomeFragment? = null

        @Synchronized
        fun getInstance(): HomeFragment{
            if(mInstance == null) mInstance = HomeFragment()
            return mInstance!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val homeFragmentView:View = inflater!!.inflate(R.layout.fragment_home, container, false)
        return homeFragmentView
    }
}