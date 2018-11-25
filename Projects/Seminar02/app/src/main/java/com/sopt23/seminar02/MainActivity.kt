package com.sopt23.seminar02

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import com.sopt23.seminar02.fragment.HomeFragment
import com.sopt23.seminar02.fragment.UserFragment
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    var message:String? = null
    var myNum:Int = 0
    var nullControl: String? = null

    var REQUEST_CODE_USER_ACTIVITY:Int = 1001;

    var backPressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(HomeFragment.getInstance())
        btn_home_fragment.setOnClickListener{
            replaceFragment(HomeFragment.getInstance())
        }
        btn_user_fragment.setOnClickListener{
            replaceFragment(UserFragment.getInstance())
        }


        intent.getStringExtra("message")?.let{
            // only when it is not null
            message = it
        };
        myNum = intent.getIntExtra("myNum", 0)
        toast("$message, $myNum")

        btn_goto_subactivity.setOnClickListener{
            // btn_goto_subactivity clicked
            /*
            val intent:Intent = Intent(this@MainActivity,  UserActivity::class.java)
            intent.putExtra("userName", "JahyunKim")
            startActivityForResult(intent, REQUEST_CODE_USER_ACTIVITY)
            */

            startActivityForResult<UserActivity>(REQUEST_CODE_USER_ACTIVITY, "userName" to "JahyunKim")
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE_USER_ACTIVITY){
            if(resultCode == 100){
                toast("결과 코드: 100")
            }
            else if(resultCode == 200){
                toast("결과 코드 : 200")
            }
            else if(resultCode == Activity.RESULT_OK){
                toast("결과 코드 : RESULT_OK")
                data?.let{
                    toast("${data.getStringExtra("resultData")}")
                }
            }
        }
    }

    override fun onBackPressed() {
        var temp: Long = System.currentTimeMillis()
        var intervalTime: Long = temp - backPressedTime
        if (intervalTime in 0..2000) {
            super.onBackPressed()
        } else {
            backPressedTime = temp
            toast("버튼을 한번 더 누르면 종료됩니다.")
        }
    }

    private fun addFragment(fragment : Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fl_main_act_frame_block, fragment)
        transaction.commit()
    }
    private fun replaceFragment(fragment : Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fl_main_act_frame_block, fragment)
        transaction.commit()
    }

    override fun onStart(){
        super.onStart()
    }
}
