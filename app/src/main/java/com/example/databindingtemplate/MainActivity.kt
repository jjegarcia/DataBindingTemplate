package com.example.databindingtemplate

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.databindingtemplate.databinding.ActivityMainBinding
import com.example.databindingtemplate.VM as VM1

class MainActivity : AppCompatActivity() {
//    private val viewModel by lazy {
//        ViewModelProviders.of(this).get(VM::class.java)
//    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//       val binding: ActivityMainBinding = DataBindingUtil.setContentView(
//            this, R.layout.activity_main
//        )
//        binding.viewModel = viewModel
        ActivityMainBinding.inflate(LayoutInflater.from(this)).apply {
            setContentView(root)
            viewModel =com.example.databindingtemplate.VM()
            lifecycleOwner = this@MainActivity
        }

    }
}
