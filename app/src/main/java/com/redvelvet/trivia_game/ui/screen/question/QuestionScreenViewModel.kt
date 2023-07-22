package com.redvelvet.trivia_game.ui.screen.question

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.redvelvet.trivia_game.domain.GetQuestionsUseCase
import com.redvelvet.trivia_game.domain.entity.Question
import com.redvelvet.trivia_game.domain.utils.TriviaException
import com.redvelvet.trivia_game.ui.navigation.Keys
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class QuestionScreenViewModel @Inject constructor(
    private val getQuestionsUseCase: GetQuestionsUseCase,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _data: MutableStateFlow<QuestionScreenUiState> = MutableStateFlow(
        QuestionScreenUiState()
    )
    val data = _data.asStateFlow()

    private val _questionManager: MutableStateFlow<QuestionManager> =
        MutableStateFlow(QuestionManager())
    val questionManager = _questionManager.asStateFlow()

    private val _currentQuestion: MutableStateFlow<QuestionState> =
        MutableStateFlow(QuestionState())
    val currentQuestion = _currentQuestion.asStateFlow()


    init {
        getData()
        loadFirstQuestion()
    }

    fun checkAnswer(answer: String) {
        viewModelScope.launch {
            if (answer == _currentQuestion.value.question.correctAnswer) {
                _currentQuestion.update {
                    QuestionState(type = QuestionType.CORRECT, correct = it.correct + 1)
                }
                delay(400)
                goToNextQuestion()
            } else if (answer != _currentQuestion.value.question.correctAnswer) {
                _currentQuestion.update {
                    QuestionState(type = QuestionType.WRONG)
                }
                delay(400)
                goToNextQuestion()
            } else {
                _currentQuestion.update {
                    QuestionState(type = QuestionType.NONE)
                }
                delay(400)
                goToNextQuestion()
            }
        }
    }

    private fun goToNextQuestion() {
        viewModelScope.launch {
            val next = _questionManager.value.currentQuestion + 1
            if (next < _data.value.questionList.size) {
                _questionManager.update {
                    it.copy(currentQuestion = next)
                }
                withContext(Dispatchers.Main){
                    updateQuestion()
                }
            } else if (next >= _data.value.questionList.size) {
                _questionManager.update {
                    it.copy(lastQuestion = true)
                }
                withContext(Dispatchers.Main){
                    updateQuestion()
                }
            }
        }
    }

    private fun loadFirstQuestion() {
        if (_data.value.questionList.isNotEmpty()) {
            updateQuestion()
        }
    }

    private fun updateQuestion() {
        _currentQuestion.update {
            QuestionState(question = _data.value.questionList[_questionManager.value.currentQuestion])
        }
    }

    private fun getData() {
        val mode = requireNotNull(savedStateHandle[Keys.Arg_Mode]) as String
        val categories = requireNotNull(savedStateHandle[Keys.Arg_Categories]) as String
        val difficulties = requireNotNull(savedStateHandle[Keys.Arg_Chips]) as String

        viewModelScope.launch {
            try{
                _data.update {
                    QuestionScreenUiState(
                        isLoading = false, questionList = getQuestionsUseCase.invoke(
                            categories = categories, difficulties = difficulties
                        )
                    )
                }
            }catch (e: TriviaException){
                _data.update {
                    it.copy(isError = Pair(true,e.message.toString()))
                }
            }
            updateQuestion()
            Log.w("MRR", data.value.questionList.toString())
        }
    }
}

data class QuestionScreenUiState(
    val isLoading: Boolean = true, val questionList: List<Question> = emptyList(),val isError:Pair<Boolean,String> = Pair(false,"")
)


data class QuestionManager(
    val currentQuestion: Int = 0, val lastQuestion: Boolean = false
)

data class QuestionState(
    val question: Question = Question(
        "Loading", "Loading", "Loading", emptyList(), "Loading", "Loading"
    ), val type: QuestionType = QuestionType.NONE,
    val correct: Int = 0
)

enum class QuestionType {
    CORRECT, WRONG, NONE
}