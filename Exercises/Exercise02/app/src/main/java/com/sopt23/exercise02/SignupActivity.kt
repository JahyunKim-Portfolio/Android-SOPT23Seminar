package com.sopt23.exercise02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signup.*

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val edtID: String = intent.getStringExtra("edtID")
        edt_id_signup.setText(edtID)

        btn_complete_signup.setOnClickListener{
            val intent: Intent = Intent()
            intent.putExtra("edtID", edt_id_signup.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

        btn_cancel_signup.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

    }
}
