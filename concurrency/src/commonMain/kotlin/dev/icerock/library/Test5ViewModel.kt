package dev.icerock.library

import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Test5ViewModel : ViewModel() {
    val resultLiveData: MutableLiveData<String> = MutableLiveData(initialValue = "nothing")

    fun onButtonPressed() {
        viewModelScope.launch {
            resultLiveData.value = withContext(Dispatchers.Default) {
                val input = listOf(1, 2)
                val sum: Int = input.sum()
                val result = input + sum
                result.toString()
            }
        }
    }
}
