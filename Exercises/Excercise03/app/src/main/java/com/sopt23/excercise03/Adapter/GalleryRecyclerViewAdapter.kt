package com.sopt23.excercise03.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.sopt23.excercise03.Data.MyItemData
import com.sopt23.excercise03.R
import kotlinx.android.synthetic.main.rv_item_gallery.view.*

class GalleryRecyclerViewAdapter(val ctx: Context, val dataList: ArrayList<MyItemData>): RecyclerView.Adapter<GalleryRecyclerViewAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.rv_item_gallery, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.counter.text = dataList[position].counter.toString()
        if(dataList[position].isLike) holder.img_like.visibility = View.VISIBLE
        else holder.img_like.visibility = View.INVISIBLE

        holder.item_btn.setOnClickListener{
            Toast.makeText(ctx, holder.counter.text, Toast.LENGTH_LONG).show();
        }
    }

    inner class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        val counter: TextView = itemView.findViewById(R.id.txt_rv_counter) as TextView
        val img_like: ImageView =  itemView.findViewById(R.id.img_rv_like) as ImageView
        val item_btn: RelativeLayout = itemView.findViewById(R.id.btn_rv_item_gallery) as RelativeLayout
    }
}