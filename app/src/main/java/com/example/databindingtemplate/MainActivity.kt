package com.example.databindingtemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Transformations.map
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val initialCardsList = mutableListOf<Card>()

        initialCardsList.addAll(addSingleDeck())
        initialCardsList.addAll(addSingleDeck())

        val cardList=initialCardsList

      buildBoard(cardList)

    }

    private fun addSingleDeck(): List<Card>  = ValidCards.values().map { Card(it, flipped = false, clickable = true) }

    private fun buildBoard(cardList: List<Card>) {
        val adapter = CardBoardAdapter(cardList)

        val recyclerView = findViewById(R.id.Recycler) as RecyclerView

        recyclerView.adapter = adapter

        val manager = GridLayoutManager(this, 4)

        recyclerView.layoutManager = manager
           adapter.setData()
    }

}
