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
    val list: List<Card>,
    var firstMove: Boolean = true,
    var lastCard: Card? = null,
    var lastCardPostion: Int=0
) : RecyclerView.Adapter<CardBoardAdapter.ViewHolder>() {
//    class CardBoardAdapter(val list: ArrayList<Card>) : RecyclerView.CardBoardAdapter<com.example.databindingtemplate.CardBoardAdapter.ViewHolder>() {

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
                checkMove(holder,position)
            }
        })
    }

    private fun flipCard(holder: ViewHolder, position: Int) {
        Log.i("VS", "Card " + list[position].key)
        holder.cardImageView.apply {
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
        if (imageFlipped)
            flipImage = list[position].frontImage.imageNumber
        else
            flipImage = list[position].backImage.imageNumber
        list[position].flipped = !imageFlipped
        return flipImage
    }

    private fun checkMove(holder: ViewHolder, position: Int) {
        var matchedCard: Boolean =false
        if (firstMove) {
        } else {
            if (list[position].key == lastCard?.key) {
                matchedCard=true
            }
            if(matchedCard){
                list[position].clickable = false
                lastCard?.clickable = false
            }
            else{
                //flip the card---wait--to do flip both cards
                flipCard(holder,position)
                val handler = Handler()
                handler.postDelayed(5000) {

                }
                flipCard(holder,position)
                flipCard(holder,lastCardPostion)

            }
        }
        firstMove=!firstMove
        if (list[position].clickable) {
            flipCard(holder, position)
        }
        lastCard = list[position]
        lastCardPostion=position
    }

    private fun setImage(holder: ViewHolder, position: Int) {
        holder.cardImageView.apply {
            setImageDrawable(
                ContextCompat.getDrawable(
                    holder.cardImageView.context,
                    list[position].frontImage.imageNumber
                )
            )


        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val cardImageView: ImageView

        init {
            cardImageView = itemView.findViewById(R.id.card_image)
        }

//        val cardImageView=itemView.findViewById(R.id.card_image) as ImageView
    }

}