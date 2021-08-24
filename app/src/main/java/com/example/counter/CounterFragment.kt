package com.example.counter


import android.os.Bundle
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.counter.databinding.FragmentCounterBinding
import dagger.hilt.android.AndroidEntryPoint
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import javax.inject.Inject

@AndroidEntryPoint
class CounterFragment : MvpAppCompatFragment(R.layout.fragment_counter), CounterView {

    companion object {
        @JvmStatic
        fun newInstance() = CounterFragment()
    }

    private val binding: FragmentCounterBinding by viewBinding()

    @Inject
    lateinit var counterPresenter: CounterPresenter
    private val presenter: CounterPresenter by moxyPresenter { counterPresenter }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize(){
        with(binding){
            btnCount.setOnClickListener {
                presenter.btnCounterClicked(tvCount.text.toString().toInt())
            }
        }
    }

    override fun updateCounter(number: Int) {
        binding.tvCount.text = "$number"
    }
}