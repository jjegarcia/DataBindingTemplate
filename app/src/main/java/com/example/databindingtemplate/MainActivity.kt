package com.example.databindingtemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val initialCardsList = createList()

        val cardList=initialCardsList//.shuffled()

//        val newBoard = Board(cardList)
        buildBoard(cardList)


    }

    fun createList(): List<Card> {
        return listOf<Card>(
        Card(1,frontImages.AVATAR1,backImages.UNMATCHED,false),
        Card(2,frontImages.AVATAR2,backImages.UNMATCHED,false),
//        Card(3,frontImages.AVATAR3,backImages.UNMATCHED,false),
//        Card(4,frontImages.AVATAR4,backImages.UNMATCHED,false),
//        Card(5,frontImages.AVATAR5,backImages.UNMATCHED,false),
//        Card(6,frontImages.AVATAR6,backImages.UNMATCHED,false),
//        Card(7,frontImages.AVATAR7,backImages.UNMATCHED,false),
//        Card(8,frontImages.AVATAR8,backImages.UNMATCHED,false),
//        Card(9,frontImages.AVATAR9,backImages.UNMATCHED,false),
//        Card(10,frontImages.AVATAR10,backImages.UNMATCHED,false),
//        Card(11,frontImages.AVATAR11,backImages.UNMATCHED,false),
//        Card(12,frontImages.AVATAR12,backImages.UNMATCHED,false),
//        Card(13,frontImages.AVATAR13,backImages.UNMATCHED,false),
//        Card(14,frontImages.AVATAR14,backImages.UNMATCHED,false),
//        Card(15,frontImages.AVATAR15,backImages.UNMATCHED,false),
//        Card(16,frontImages.AVATAR16,backImages.UNMATCHED,false),
        Card(1,frontImages.AVATAR1,backImages.UNMATCHED,false),
        Card(2,frontImages.AVATAR2,backImages.UNMATCHED,false)//,
//        Card(3,frontImages.AVATAR3,backImages.UNMATCHED,false),
//        Card(4,frontImages.AVATAR4,backImages.UNMATCHED,false),
//        Card(5,frontImages.AVATAR5,backImages.UNMATCHED,false),
//        Card(6,frontImages.AVATAR6,backImages.UNMATCHED,false),
//        Card(7,frontImages.AVATAR7,backImages.UNMATCHED,false),
//        Card(8,frontImages.AVATAR8,backImages.UNMATCHED,false),
//        Card(9,frontImages.AVATAR9,backImages.UNMATCHED,false),
//        Card(10,frontImages.AVATAR10,backImages.UNMATCHED,false),
//        Card(11,frontImages.AVATAR11,backImages.UNMATCHED,false),
//        Card(12,frontImages.AVATAR12,backImages.UNMATCHED,false),
//        Card(13,frontImages.AVATAR13,backImages.UNMATCHED,false),
//        Card(14,frontImages.AVATAR14,backImages.UNMATCHED,false),
//        Card(15,frontImages.AVATAR15,backImages.UNMATCHED,false),
//        Card(16,frontImages.AVATAR16,backImages.UNMATCHED,false)
        )
    }

    private fun buildBoard(cardList: List<Card>) {
        val adapter = CardBoardAdapter(cardList)

        val recyclerView = findViewById(R.id.Recycler) as RecyclerView

        recyclerView.adapter = adapter

        val manager = GridLayoutManager(this, 2)

        recyclerView.layoutManager = manager


           adapter.setData()
    }

}
