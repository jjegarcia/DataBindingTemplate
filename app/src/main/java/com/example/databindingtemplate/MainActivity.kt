package com.example.databindingtemplate

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingtemplate.databinding.ActivityMainBinding
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
//import sun.jvm.hotspot.utilities.IntArray



class MainActivity : AppCompatActivity() {
    //lateinit var cardList :ArrayList<Card>
    //lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


//        ActivityMainBinding.inflate(LayoutInflater.from(this)).apply {
//            setContentView(root)
//            viewModel = com.example.databindingtemplate.VM()
//            lifecycleOwner = this@MainActivity
//        }



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
