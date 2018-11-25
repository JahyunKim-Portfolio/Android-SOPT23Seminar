package com.sopt23.seminar02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_user.*

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        btn_returnto_mainactivity.setOnClickListener{
            //btn_returnto_mainactivity clicked
            // (it as Button).text = "Close"
            val userName:String = intent.getStringExtra("userName")
            val intent: Intent = Intent()
            intent.putExtra("resultData", "${userName} is alived")
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
