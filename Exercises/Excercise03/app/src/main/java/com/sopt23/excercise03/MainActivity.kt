package com.sopt23.excercise03

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.GridLayout
import com.sopt23.excercise03.Adapter.GalleryRecyclerViewAdapter
import com.sopt23.excercise03.Data.MyItemData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var galleryRecyclerViewAdapter: GalleryRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()
    }

    private fun setRecyclerView() {
        var dataList: ArrayList<MyItemData> = ArrayList()
        for(x in 1..20) {
            dataList.add(MyItemData(x, x%2==0))
        }
        galleryRecyclerViewAdapter = GalleryRecyclerViewAdapter(this, dataList)
        rv_gallery_main.adapter = galleryRecyclerViewAdapter
        rv_gallery_main.layoutManager = GridLayoutManager(this, 3)
    }
}
