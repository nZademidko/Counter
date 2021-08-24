package com.example.counter

import moxy.MvpPresenter
import javax.inject.Inject

class CounterPresenter @Inject constructor() : MvpPresenter<CounterView>() {


    fun btnCounterClicked(number: Int) {
        viewState.updateCounter(number + 1)
    }
}