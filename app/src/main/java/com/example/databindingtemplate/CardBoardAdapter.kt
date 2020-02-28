package com.example.databindingtemplate

import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

var dontListen :Boolean =false
class CardBoardAdapter constructor(
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

    private fun checkMove(holder: ViewHolder, position: Int) {
        handleSingleClick(position, holder)
    }

    private fun handleSingleClick(position: Int, holder: ViewHolder) {
        if (!dontListen) {
            if (list[position].clickable) handleClickableCard(holder, position)
        }
    }

    private fun handleClickableCard(holder: ViewHolder, position: Int ) {
        flipCard(holder, position)
        handleLifts(position, holder)
        firstMove = !firstMove
    }

    private fun handleLifts(position: Int, holder: ViewHolder) {
        if (firstMove) handleFirstLift(position, holder)
        else handleSecondLift(holder, position)
    }

    private fun handleSecondLift(holder: ViewHolder, position: Int) {
        holder.itemView.isClickable = false
        if (list[position].cardtype.key == lastCard?.cardtype?.key) list[position].clickable = false
         else reverseCard(position, holder)
    }

    private fun handleFirstLift(position: Int, holder: ViewHolder) {
        list[position].clickable = false
        lastCardHolder = holder
        lastCardPostion = position
        lastCard = list[position]
    }

    private fun reverseCard(position: Int, holder: ViewHolder) {
        dontListen = true
        list[position].clickable = true
        lastCard?.clickable = true
        val handler = Handler()
        handler.postDelayed({
            flipCard(holder, position)
            flipCard(lastCardHolder, lastCardPostion)
            holder.itemView.isClickable = true
            dontListen = false
        }, 3000)
    }

    private fun flipCard(holder: ViewHolder, position: Int) {
        Log.i("VS", "Card " + list[position].cardtype.key)
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
            flipImage = list[position].cardtype.backImage
        else
            flipImage = list[position].cardtype.frontImage
        return flipImage
    }

    private fun setImage(holder: ViewHolder, position: Int) {
        holder.cardImageView.apply {
            setImageDrawable(
                ContextCompat.getDrawable(
                    holder.cardImageView.context,
                    list[position].cardtype.backImage
                )
            )
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardImageView: ImageView

        init {
            cardImageView = itemView.findViewById(R.id.card_image)
        }
    }
}