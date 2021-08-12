package dev.icerock.library

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Test3ViewModel : ViewModel() {
    fun onButtonPressed() {
        val calculatedData = mutableListOf(1, 2)
        viewModelScope.launch(Dispatchers.Default) {
            val sum = calculatedData.sum()
            calculatedData.add(sum)
            println(calculatedData)
        }
    }
}
