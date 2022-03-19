package com.aidul23.kotlinflowexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val timeText: TextView = findViewById(R.id.tvCountDown)

//        viewModel.timer().observe(this, Observer {
//            timeText.text = it.toString()
//        })

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.countDownFlow
                //flow operator
                //this actually filtered the number which is even
                .filter {
                    it % 2 == 0
                }
                //flow operator
                //this actually map the value or you can anything with the data here
                .map {
                    it * it
                }
                .collect {
                    timeText.text = it.toString()
                }

            //Simple Flow Operators are:
            //filter, map, onEach

            //Terminal Flow Operators are:
            //count, reduce, fold

            //Flattening Flow Operators are:
            //flatMapConcat, flatMapMerge, flatMapLatest

            //Other Flow Operators
            //buffer, conflate, collectLatest
        }
    }
}