package com.example.databindingtemplate

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.databindingtemplate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityMainBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
            viewModel =com.example.databindingtemplate.VM()
            lifecycleOwner = this@MainActivity
        }

    }
}
