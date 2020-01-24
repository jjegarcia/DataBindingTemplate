package com.example.databindingtemplate

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CardBoardAdapter(val list: Board) : RecyclerView.Adapter<CardBoardAdapter.ViewHolder>() {
//    class CardBoardAdapter(val list: ArrayList<Card>) : RecyclerView.CardBoardAdapter<com.example.databindingtemplate.CardBoardAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_tile, parent, false)
        return ViewHolder(v)
    }

    fun setData(){
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.boardArray.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        setImage(holder, position)
        holder.itemView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                flipCard()
            }

            private fun flipCard() {
                Log.i("VS", "Card " + list.boardArray[position].card.key)
                val apply = holder.cardImageView.apply {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            holder.cardImageView.context,
                            list.boardArray[position].card.backImage.imageNumber
                        )
                    )
                }
            }
        })
    }

    private fun setImage(holder: ViewHolder, position: Int) {
        holder.cardImageView.apply {
            setImageDrawable(
                ContextCompat.getDrawable(
                    holder.cardImageView.context,
                    list.boardArray[position].card.frontImage.imageNumber
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