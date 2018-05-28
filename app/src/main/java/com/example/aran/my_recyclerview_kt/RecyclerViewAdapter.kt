package com.example.aran.my_recyclerview_kt

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_list.view.*
//TODO (7) buat kelas baru yang akan digunakan sebagai adapter untuk menampilkan data ke RecyclerView
class RecyclerViewAdapter (private val context: Context, private val items: List<Item>)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view){

        fun bindItem(items: Item){
            itemView.name.text = items.name
            Glide.with(itemView.context).load(items.image).into(itemView.image)
        }
    }
}