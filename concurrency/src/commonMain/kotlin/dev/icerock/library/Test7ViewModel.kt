package dev.icerock.library

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Test7ViewModel : ViewModel() {
    fun onButtonPressed() {
        println("onButtonPressed start")
        viewModelScope.launch {
            for (i in 1 .. 3) {
                delay(1000)
                println("Hi $i")
            }
        }
        println("onButtonPressed complete")
    }
}
