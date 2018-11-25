package com.sopt23.seminar02.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sopt23.seminar02.R

class UserFragment: Fragment(){
    companion object{
        var mInstance : UserFragment? = null

        @Synchronized
        fun getInstance(): UserFragment{
            if(mInstance == null) mInstance = UserFragment()
            return mInstance!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val userFragmentView: View = inflater!!.inflate(R.layout.fragment_user, container, false)
        return userFragmentView
    }

}