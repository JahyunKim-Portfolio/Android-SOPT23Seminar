package com.sopt23.seminar03.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.sopt23.seminar03.Data.KakaoTalkRoomData
import com.sopt23.seminar03.MainActivity
import com.sopt23.seminar03.R
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class KakaoTalkRoomRecyclerViewAdapter(val ctx:Context, val datalist : ArrayList<KakaoTalkRoomData>): RecyclerView.Adapter<KakaoTalkRoomRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_kakao_talk_room, parent)
        return Holder(view)
    }

    override fun getItemCount(): Int = datalist.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.title.text = datalist[position].title
        holder.content.text = datalist[position].content
        holder.person_cnt.text = datalist[position].person_cnt.toString()
        holder.time.text = datalist[position].time
        holder.item_btn.setOnClickListener{
            ctx.toast("To the Main Activity")
            ctx.startActivity<MainActivity>()
        }
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        val title : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_title) as TextView
        val content : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_content) as TextView
        val person_cnt : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_person_cnt) as TextView
        val time : TextView = itemView.findViewById(R.id.tv_rv_item_kakao_talk_room_time) as TextView
        val item_btn : RelativeLayout = itemView.findViewById(R.id.btn_rv_item_kakao_talk_rook) as RelativeLayout
    }
}