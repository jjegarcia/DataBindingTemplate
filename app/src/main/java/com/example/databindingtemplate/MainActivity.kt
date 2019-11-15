package com.example.databindingtemplate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val card = Card("icon1", R.drawable.ic_launcher_foreground)
        val card20=Card("icon20",R.drawable.avatar_1_raster)
        val card2=Card("icon20",R.drawable.avatar_2_raster)
        val card3=Card("icon20",R.drawable.avatar_3_raster)


        var cardList = ArrayList<Card>()
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card20)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card2)//1
        cardList.add(card3)//1
        cardList.add(card3)//1
        cardList.add(card3)//1
        cardList.add(card3)//1
        cardList.add(card3)//1
        cardList.add(card3)//1
        cardList.add(card3)//1
        cardList.add(card3)//1
        cardList.add(card3)//1


        val adapter = Adapter(cardList)

        val recyclerView = findViewById(R.id.Recycler) as RecyclerView

        recyclerView.adapter=adapter

       val manager = GridLayoutManager(this, 5, GridLayoutManager.VERTICAL, false)

               recyclerView.layoutManager = manager


        //   adapter.setData()



    }
}
