package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        viewModel.currentNumber.observe(this, Observer {
            tv_textview.text = it.toString()
        })


        viewModel.currentBoolean.observe(this, Observer {
            tv_booleantext.text = it.toString()
        })

        incrementText()
    }

    private fun incrementText(){
        btn_button.setOnClickListener {
            viewModel.currentNumber.value = ++viewModel.number
            viewModel.currentBoolean.value = viewModel.number % 2 ==0


        }
    }

}