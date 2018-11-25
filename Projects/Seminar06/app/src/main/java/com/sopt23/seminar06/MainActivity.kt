package com.sopt23.seminar06

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import com.sopt23.seminar06.db.SharedPreferenceController
import com.sopt23.seminar06.network.ApplicationController
import com.sopt23.seminar06.network.NetworkService
import com.sopt23.seminar06.post.PostLoginResponse
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val networkService: NetworkService by lazy{
        ApplicationController.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setOnBtnClickListener()

        if(SharedPreferenceController.getAuthorization(this).isNotEmpty()){
            startActivity<BoardActivity>()
        }
    }

    private fun setOnBtnClickListener(){
        btn_main_act_log_in.setOnClickListener{
            getLoginResponse()
        }
        btn_main_act_sign_up.setOnClickListener{
            startActivity<SignupActivity>()
        }
    }

    private fun getLoginResponse(){
        if(et_main_act_email.text.toString().isNotEmpty() && et_main_act_pw.text.toString().isNotEmpty()){
            val input_email = et_main_act_email.text.toString()
            val input_pw = et_main_act_pw.text.toString()
            val jsonObject: JSONObject = JSONObject()
            jsonObject.put("email", input_email)
            jsonObject.put("password", input_pw)
            val gsonObject : JsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

            val postLogInResponse = networkService.postLoginResponse("application/json", gsonObject)
            postLogInResponse.enqueue(object: Callback<PostLoginResponse>{
                override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                    Log.e("Login Fail", t.toString())
                }

                override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {
                    if(response.isSuccessful){
                        val token = response.body()!!.data.token
                        SharedPreferenceController.setAuthorization(this@MainActivity, token)
                        toast(SharedPreferenceController.getAuthorization(this@MainActivity))
                        startActivity<BoardActivity>()
                    }
                }
            })
        }
    }
}
