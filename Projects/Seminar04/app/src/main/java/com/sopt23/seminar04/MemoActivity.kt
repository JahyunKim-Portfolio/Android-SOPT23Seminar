package com.sopt23.seminar04

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.sopt23.seminar04.Adapter.MemoRecyclerViewAdapter
import com.sopt23.seminar04.DB.SharedPreferenceController
import com.sopt23.seminar04.Data.MemoData
import kotlinx.android.synthetic.main.activity_memo.*
import kotlinx.android.synthetic.main.rv_item_memo.*
import org.jetbrains.anko.startActivity

class MemoActivity : AppCompatActivity() {

    lateinit var memoRecyclerViewAdapter: MemoRecyclerViewAdapter
    val dataList: ArrayList<MemoData> = ArrayList<MemoData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo)

        srl_memo_act_refresh.setOnRefreshListener {
            srl_memo_act_refresh.isRefreshing = false
        }

        setOnBtnClickListener()
        setRecyclerView()
    }

    private fun setRecyclerView(){
        memoRecyclerViewAdapter = MemoRecyclerViewAdapter(this, dataList)
        rv_memo_act_memo_list.adapter = memoRecyclerViewAdapter
        rv_memo_act_memo_list.layoutManager = LinearLayoutManager(this)
    }

    fun setOnBtnClickListener(){
        btn_memo_act_logout.setOnClickListener{
            SharedPreferenceController.clearUserSharedPreferences(this)
            startActivity<LoginActivity>()
            finish()
        }
        btn_memo_act_add_memo.setOnClickListener{
            if(et_memo_act_title.text.toString().isNotEmpty() && et_memo_act_content.text.toString().isNotEmpty()){
                val title: String = et_memo_act_title.text.toString()
                val content: String = et_memo_act_content.text.toString()

                val memoData: MemoData = MemoData(title, content)
                memoRecyclerViewAdapter.dataList.add(memoData)
                memoRecyclerViewAdapter.notifyDataSetChanged()
            }
        }
    }
}
