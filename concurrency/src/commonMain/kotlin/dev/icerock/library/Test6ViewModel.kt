package dev.icerock.library

import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Test6ViewModel : ViewModel() {
    val resultLiveData: MutableLiveData<String> = MutableLiveData(initialValue = "nothing")

    fun onButtonPressed() {
        viewModelScope.launch(Dispatchers.Default) {
            val calculatedData = mutableListOf(1, 2)
            val sum = calculatedData.sum()
            calculatedData.add(sum)

            resultLiveData.value = calculatedData.toString()
        }
    }
}
