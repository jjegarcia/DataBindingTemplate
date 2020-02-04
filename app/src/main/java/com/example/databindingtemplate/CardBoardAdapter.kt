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
//    class CardBoardAdapter(val list: ArrayList<Card>) : RecyclerView.CardBoardAdapter<com.example.databindingtemplate.CardBoardAdapter.ViewHolder>() {
    var firstMove: Boolean = true
    var lastCardHolder: ViewHolder?=null
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
                //               flipCard(holder,position)
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
//        notifyDataSetChanged()
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
            var matchedCard: Boolean = false
            if (firstMove) {
                flipCard(holder, position)
                list[position].clickable=false
            } else {
                if (list[position].key == lastCard?.key) {
                    matchedCard = true
                }
                if (matchedCard) {
                    list[position].clickable = false
                    lastCard?.clickable = false
                } else {
                    //flip the card---wait-- flip both cards-make both back to clickable
                    list[position].clickable = true
                    lastCard?.clickable = true
                    val handler = Handler()
                    handler.postDelayed(5000) {
                        flipCard(holder, position)
                    }
                    lastCardHolder?.let { flipCard(it, lastCardPostion) }
                    flipCard(holder, position)
                }
            }
            lastCardHolder = holder
            lastCardPostion = position
            lastCard=list[position]
            firstMove = !firstMove
        }
    }

    private fun setImage(holder: ViewHolder, position: Int) {
        holder.cardImageView.apply {
            setImageDrawable(
//                if(holder.isFront) {  suggested
                ContextCompat.getDrawable(
                    holder.cardImageView.context,
                    list[position].backImage.imageNumber
                )
            )


        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cardImageView: ImageView
 //       var isFront = false  suggested

        init {
            cardImageView = itemView.findViewById(R.id.card_image)
        }

//        val cardImageView=itemView.findViewById(R.id.card_image) as ImageView
    }

}