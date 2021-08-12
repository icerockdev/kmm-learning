package dev.icerock.library

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.utils.printThread
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.launch

class Test1ViewModel(
    private val httpClient: HttpClient
) : ViewModel() {
    fun onButtonPressed() {
        println("1")
        printThread()
        viewModelScope.launch {
            println("2")
            printThread()
            httpClient.get<String>("https://icerockdev.com")
            println("3")
            printThread()
        }
        println("4")
        printThread()
    }
}
