package com.example.aran.my_recyclerview_kt

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.aran.my_recyclerview_kt.R.array.club_image
import com.example.aran.my_recyclerview_kt.R.array.club_name
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//TODO (8) Pada kelas MainActivity.Kt, tambahkan variabel items dan deklarasikan variabel tersebut sebagai MutableList dari kelas Item.Kt
    private var items: MutableList<Item> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//TODO (10) Pada method onCreate, panggil fungsi initData() yang telah kita buat dan deklarasikan RecyclerView beserta adapter-nya
        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items)
    }
//TODO (9) Buat fungsi atau method untuk memasukkan array yang sudah kita buat ke dalam data class
    private fun initData(){
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        items.clear()
        for (i in name.indices){
            items.add(Item(name[i],
                    image.getResourceId(i,0)))
        }
        image.recycle()
    }
}
