package com.sopt23.exercise02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQUEST_SIGNUP: Int = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_signup_main.setOnClickListener {
            val intent: Intent = Intent(this@MainActivity, SignupActivity::class.java)
            intent.putExtra("edtID", edt_id_main.text.toString())
            startActivityForResult(intent, REQUEST_SIGNUP)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_SIGNUP){
            if(resultCode == Activity.RESULT_OK){
                edt_id_main.setText(data!!.getStringExtra("edtID"))
                Toast.makeText(this, "Signup OK", Toast.LENGTH_SHORT)
            }
            else if(resultCode == Activity.RESULT_CANCELED){
                Toast.makeText(this, "Signup Cancled", Toast.LENGTH_SHORT)
            }
        }
    }
}
