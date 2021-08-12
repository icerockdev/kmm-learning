package dev.icerock.library

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Test8ViewModel : ViewModel() {
    fun onButtonPressed() {
        viewModelScope.launch(Dispatchers.Default) {
            val calculatedData = mutableListOf(1, 2)
            val sum = calculatedData.sum()
            calculatedData.add(sum)

            println(calculatedData)
        }
    }
}
