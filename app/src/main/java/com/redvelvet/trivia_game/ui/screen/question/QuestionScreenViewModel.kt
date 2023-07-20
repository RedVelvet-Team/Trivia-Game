package com.redvelvet.trivia_game.ui.screen.question

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.trivia_game.domain.GetQuestionsUseCase
import com.redvelvet.trivia_game.domain.entity.Question
import com.redvelvet.trivia_game.ui.navigation.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionScreenViewModel @Inject constructor(
    private val getQuestionsUseCase: GetQuestionsUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _data: MutableStateFlow<QuestionScreenUiState> = MutableStateFlow(
        QuestionScreenUiState()
    )
    val data = _data.asStateFlow()

    init {
        getData()
    }

    private fun getData() {
        val mode = requireNotNull(savedStateHandle[Keys.Arg_Mode]) as String
        val categories = requireNotNull(savedStateHandle[Keys.Arg_Categories]) as String
        val difficulties = requireNotNull(savedStateHandle[Keys.Arg_Chips]) as String

        viewModelScope.launch {
            _data.update {
                QuestionScreenUiState(
                    isLoading = false,
                    questionList = getQuestionsUseCase.invoke(
                        categories = categories,
                        difficulties = difficulties
                    )
                )
            }
            delay(2000)
            Log.w("MRR",data.value.questionList.toString())
        }
    }
}

data class QuestionScreenUiState(
    val isLoading: Boolean = true,
    val questionList: List<Question> = emptyList()
)