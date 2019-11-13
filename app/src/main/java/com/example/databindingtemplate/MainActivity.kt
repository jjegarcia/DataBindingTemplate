package com.example.databindingtemplate

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingtemplate.databinding.ActivityMainBinding

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

        var cardList = ArrayList<Card>()
        cardList.add(card)
        cardList.add(card)
        cardList.add(card)
        cardList.add(card)
        cardList.add(card)
        cardList.add(card)

        val adapter = Adapter(cardList)

        val recyclerView = findViewById(R.id.Recycler) as RecyclerView

        recyclerView.adapter=adapter

     //   adapter.setData()



    }
}
