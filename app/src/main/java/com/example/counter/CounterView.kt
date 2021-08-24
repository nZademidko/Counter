package com.example.counter

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

interface CounterView: MvpView {

    @AddToEndSingle
    fun updateCounter(number: Int)
}