package com.example.databindingtemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val cardsList = createList()
        val newBoard = Board(cardsList)
        val game= Game(newBoard)
        buildBoard(newBoard)

    }

    fun createList(): List<CardPair> {
        return listOf<CardPair>(
            CardPair(validCards.E1.cardName, false),
            CardPair(validCards.E2.cardName, false),
            CardPair(validCards.E3.cardName, false),
            CardPair(validCards.E4.cardName, false),
            CardPair(validCards.E5.cardName, false),
            CardPair(validCards.E6.cardName, false),
            CardPair(validCards.E7.cardName, false),
            CardPair(validCards.E8.cardName, false),
            CardPair(validCards.E9.cardName, false),
            CardPair(validCards.E10.cardName, false),
            CardPair(validCards.E11.cardName, false),
            CardPair(validCards.E12.cardName, false),
            CardPair(validCards.E13.cardName, false),
            CardPair(validCards.E14.cardName, false),
            CardPair(validCards.E15.cardName, false),
            CardPair(validCards.E16.cardName, false),

            CardPair(validCards.E1.cardName, false),
            CardPair(validCards.E2.cardName, false),
            CardPair(validCards.E3.cardName, false),
            CardPair(validCards.E4.cardName, false),
            CardPair(validCards.E5.cardName, false),
            CardPair(validCards.E6.cardName, false),
            CardPair(validCards.E7.cardName, false),
            CardPair(validCards.E8.cardName, false),
            CardPair(validCards.E9.cardName, false),
            CardPair(validCards.E10.cardName, false),
            CardPair(validCards.E11.cardName, false),
            CardPair(validCards.E12.cardName, false),
            CardPair(validCards.E13.cardName, false),
            CardPair(validCards.E14.cardName, false),
            CardPair(validCards.E15.cardName, false),
            CardPair(validCards.E16.cardName, false)
        )
    }

    private fun buildBoard(cardList: Board) {
        val adapter = Adapter(cardList)

        val recyclerView = findViewById(R.id.Recycler) as RecyclerView

        recyclerView.adapter = adapter

        val manager = GridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = manager


           adapter.setData()
    }

}
