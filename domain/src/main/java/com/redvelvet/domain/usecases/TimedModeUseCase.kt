package com.redvelvet.domain.usecases

import com.redvelvet.domain.repository.TimerService

class TimedModeUseCase(private val timerService: TimerService) {

    fun startTimer() {
        timerService.startTimer(180_000)
    }

    fun stopTimer() {
        timerService.stopTimer()
    }
}
