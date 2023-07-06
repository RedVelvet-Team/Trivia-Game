package com.redvelvet.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.domain.entity.Configurations
import com.redvelvet.domain.usecases.StartGameUseCase
import com.redvelvet.presentation.ui.theme.TriviaGameTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TriviaGameTheme {
                Greeting()
            }
        }
    }
}


@Composable
fun Greeting(
    viewModel: GoodViewmodel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Button(onClick = { viewModel.startGame() }) {
        Text(text = "!")
    }
}


@HiltViewModel
class GoodViewmodel @Inject constructor(
    private val startGameUseCase: StartGameUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(QuestionUIState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            startGameUseCase.invoke(
                1, Configurations(
                    categories = listOf("music", "science", "history"),
                    difficulties = listOf("easy", "difficult"),
                )
            )
        }
    }

    fun startGame() {
        _state.update {
            it.copy(

            )
        }
    }


}

data class QuestionUIState(
    val category: String = "",
    val correctAnswer: String = "",
    val difficulty: String = "",
    val incorrectAnswers: List<String> = listOf(),
    val question: String = "",
    val type: String = ""

)