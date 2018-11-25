package com.sopt23.seminar04.DB

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController{
    private val USER_NAME: String = "user_name"
    private val USER_ID: String = "user_id"
    private val USER_PW: String = "user_pw"

    fun setUserID(ctx: Context, input_id: String){
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.putString(USER_ID, input_id)
        editor.commit()
    }

    fun setUserPW(ctx: Context, input_pw: String){
        val preferences: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preferences.edit()
        editor.putString(USER_PW, input_pw)
        editor.commit()
    }

    fun getUserID(ctx: Context) : String{
        val preferences: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        return preferences.getString(USER_ID, "")
    }

    fun getUserPW(ctx: Context) : String{
        val preferences: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        return preferences.getString(USER_PW, "")
    }

    fun clearUserSharedPreferences(ctx: Context){
        val preference: SharedPreferences = ctx.getSharedPreferences(USER_NAME, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = preference.edit()
        editor.clear()
        editor.commit()
    }
}