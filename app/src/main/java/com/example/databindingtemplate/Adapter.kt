package com.example.databindingtemplate

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class Adapter(val list: ArrayList<Card>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_tile, parent, false)
        return ViewHolder(v)
    }

    fun setData(){
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.cardImageView.setImageDrawable(ContextCompat.getDrawable(holder.cardImageView.context, list[position].sourceName))
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cardImageView: ImageView

        init {
            cardImageView = itemView.findViewById(R.id.card_image)
        }

//        val cardImageView=itemView.findViewById(R.id.card_image) as ImageView
    }

}