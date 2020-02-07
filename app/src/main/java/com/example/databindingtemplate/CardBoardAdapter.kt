package com.example.databindingtemplate

import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.os.postDelayed
import androidx.recyclerview.widget.RecyclerView

class CardBoardAdapter(
    val list: List<Card>
) : RecyclerView.Adapter<CardBoardAdapter.ViewHolder>() {
    var firstMove: Boolean = true
lateinit    var lastCardHolder: ViewHolder
    var lastCardPostion: Int = 0
    var lastCard: Card?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_tile, parent, false)
        return ViewHolder(v)
    }

    fun setData() {
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setImage(holder, position)
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                checkMove(holder, position)
            }
        })
    }

    private fun flipCard(holder: ViewHolder, position: Int) {
        Log.i("VS", "Card " + list[position].key)
        val apply = holder.cardImageView.apply {
            setImageDrawable(
                ContextCompat.getDrawable(
                    holder.cardImageView.context,
                    flip(position)
                )
            )
        }
    }

    private fun flip(position: Int): Int {
        val flipImage: Int
        val imageFlipped = list[position].flipped
        list[position].flipped = !imageFlipped
        if (imageFlipped)
            flipImage = list[position].backImage.imageNumber
        else
            flipImage = list[position].frontImage.imageNumber
        return flipImage
    }

    private fun checkMove(holder: ViewHolder, position: Int) {
        if (list[position].clickable) {
            flipCard(holder, position)
            if (firstMove) {
                list[position].clickable=false
                lastCardHolder = holder
                lastCardPostion = position
                lastCard=list[position]
            } else {
                if (list[position].key == lastCard?.key) {
                    list[position].clickable = false
                } else {
                    list[position].clickable = true
                    lastCard?.clickable = true
                    val handler = Handler()
                    handler.postDelayed( {
                        flipCard(holder, position)
                        flipCard(lastCardHolder, lastCardPostion)
                    },3000)
                }
            }
            firstMove = !firstMove
        }
    }

    private fun setImage(holder: ViewHolder, position: Int) {
        holder.cardImageView.apply {
            setImageDrawable(
                ContextCompat.getDrawable(
                    holder.cardImageView.context,
                    list[position].backImage.imageNumber
                )
            )
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cardImageView: ImageView

        init {
            cardImageView = itemView.findViewById(R.id.card_image)
        }
   fun test(){
       val handler = Handler()
               handler.postDelayed({
               }, 350)
           }

    }
}