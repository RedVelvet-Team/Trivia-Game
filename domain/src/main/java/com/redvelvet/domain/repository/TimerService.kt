package com.redvelvet.domain.repository

interface TimerService {
    fun startTimer(duration: Long)
    fun stopTimer()
}
