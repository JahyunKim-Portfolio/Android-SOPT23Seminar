package com.sopt23.seminar04.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.sopt23.seminar04.Data.MemoData
import com.sopt23.seminar04.R
import kotlinx.android.synthetic.main.rv_item_memo.view.*

class MemoRecyclerViewAdapter(val ctx: Context, var dataList: ArrayList<MemoData>): RecyclerView.Adapter<MemoRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_memo, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    fun addNewItem(memoData: MemoData){
        dataList.add(memoData)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = dataList[position].title
        holder.content.text = dataList[position].content
        holder.container.setOnClickListener{
            try {
                dataList.removeAt(position)
                notifyDataSetChanged()
            }
            catch(e: IndexOutOfBoundsException){
                Log.e("myTag", "Error occured when removing : " + e.toString())
            }
        }
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        var title: TextView = itemView.findViewById(R.id.tv_rv_item_memo_title) as TextView
        var content: TextView = itemView.findViewById(R.id.tv_rv_item_memo_content) as TextView
        var container: RelativeLayout = itemView.findViewById(R.id.btn_rv_item_memo_container) as RelativeLayout
    }
}