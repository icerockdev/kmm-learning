package dev.icerock.library

import dev.icerock.moko.test.cases.InstantTaskRule
import dev.icerock.moko.test.cases.TestCases
import dev.icerock.moko.test.waitChildrenCompletion
import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respondOk
import kotlinx.coroutines.delay
import kotlin.test.Test
import kotlin.test.assertEquals

class ViewModelsTests : TestCases() {
    private val testScopeRule = TestViewModelScopeRule()

    override val rules: List<Rule> = listOf(testScopeRule, InstantTaskRule())

    @Test
    fun `test 1`() {
        val testViewModel = Test1ViewModel(
            httpClient = HttpClient(MockEngine) {
                engine {
                    addHandler {
                        delay(10) // network demand
                        respondOk()
                    }
                }
            }
        )
        testViewModel.onButtonPressed()

        testScopeRule.coroutineScope.waitChildrenCompletion()
    }

    @Test
    fun `test 2`() {
        Test2ViewModel().onButtonPressed()

        testScopeRule.coroutineScope.waitChildrenCompletion()
    }

    @Test
    fun `test 3`() {
        Test3ViewModel().onButtonPressed()

        testScopeRule.coroutineScope.waitChildrenCompletion()
    }

    @Test
    fun `test 4`() {
        val vm = Test4ViewModel()
        vm.onButtonPressed()

        testScopeRule.coroutineScope.waitChildrenCompletion()

        assertEquals(expected = "[1, 2, 3]", actual = vm.resultLiveData.value)
    }

    @Test
    fun `test 5`() {
        val vm = Test5ViewModel()
        vm.onButtonPressed()

        testScopeRule.coroutineScope.waitChildrenCompletion()

        assertEquals(expected = "[1, 2, 3]", actual = vm.resultLiveData.value)
    }

    @Test
    fun `test 6`() {
        // on real android environment here will be crash because
        // androidx.lifecycle.LiveData.setValue
        // have assertMainThread("setValue");
        val vm = Test6ViewModel()
        vm.onButtonPressed()

        testScopeRule.coroutineScope.waitChildrenCompletion()

        assertEquals(expected = "[1, 2, 3]", actual = vm.resultLiveData.value)
    }

    @Test
    fun `test 7`() {
        val vm = Test7ViewModel()
        vm.onButtonPressed()

        testScopeRule.coroutineScope.waitChildrenCompletion()
    }

    @Test
    fun `test 8`() {
        val vm = Test8ViewModel()
        vm.onButtonPressed()

        testScopeRule.coroutineScope.waitChildrenCompletion()
    }
}
