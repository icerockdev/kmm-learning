package dev.icerock.library

import dev.icerock.moko.mvvm.test.TestViewModelScope
import dev.icerock.moko.test.cases.TestCases
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class TestViewModelScopeRule : TestCases.Rule {
    lateinit var coroutineScope: CoroutineScope

    override fun setup() {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("got $exception")
            throw exception
        }
        coroutineScope = CoroutineScope(Dispatchers.Unconfined + handler)
        TestViewModelScope.setupViewModelScope(coroutineScope)
    }

    override fun tearDown() {
        TestViewModelScope.resetViewModelScope()
    }
}
