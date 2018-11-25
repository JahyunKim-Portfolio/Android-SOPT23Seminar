package com.sopt23.seminar04

import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sopt23.seminar04.DB.SharedPreferenceController
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setOnBtnClickListener()

        if(SharedPreferenceController.getUserID(this).isNotEmpty()){
            startActivity<MemoActivity>()
            finish()
        }
    }

    private fun setOnBtnClickListener() {
        btn_login_act_sign_in.setOnClickListener{
            val input_id: String = et_login_act_id.text.toString()
            val input_passwd: String = et_login_act_pw.text.toString()

            if(input_id.isNotEmpty() && input_passwd.isNotEmpty()){
                SharedPreferenceController.setUserID(this, input_id)
                SharedPreferenceController.setUserPW(this, input_passwd)

                startActivity<MemoActivity>()
                finish()
            }
        }
    }
}
