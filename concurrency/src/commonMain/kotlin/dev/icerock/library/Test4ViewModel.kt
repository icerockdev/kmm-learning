package dev.icerock.library

import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Test4ViewModel : ViewModel() {
    val resultLiveData: MutableLiveData<String> = MutableLiveData(initialValue = "nothing")

    fun onButtonPressed() {
        viewModelScope.launch {
            resultLiveData.value = withContext(Dispatchers.Default) {
                calculateData(listOf(1, 2)).toString()
            }
        }
    }

    private fun calculateData(input: List<Int>): List<Int> {
        val sum: Int = input.sum()
        return input + sum
    }
}
