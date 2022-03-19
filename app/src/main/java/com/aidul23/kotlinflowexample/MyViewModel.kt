package com.aidul23.kotlinflowexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {

//    var timeLiveData = MutableLiveData<Int>()

    val countDownFlow = flow<Int> {
        val startTime = 10
        var currentTime = startTime
        emit(startTime)
        while(currentTime > 0) {
            delay(1000L)
            currentTime--
            emit(currentTime)
        }
    }
    
//    fun timer(): MutableLiveData<Int> {
//        viewModelScope.launch {
//            countDownFlow.collect {
//                timeLiveData.postValue(it)
//            }
//        }
//        return timeLiveData
//    }
}