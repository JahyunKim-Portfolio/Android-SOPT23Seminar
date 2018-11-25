package com.sopt23.seminar02

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.jetbrains.anko.startActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)



        Handler().apply{
            postDelayed({
                // start after 2s

                /*
                val intent : Intent = Intent(this@SplashActivity, MainActivity::class.java)
                intent.putExtra("message", "Hello MainActivity")
                intent.putExtra("myNumber","200")
                startActivity(intent)
                */
                startActivity<MainActivity>("message" to "Hello MainActivity", "myNumber" to 200)
                finish()
            }, 2000)
        }

        // startActivityForResult(intent, 7777)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}
